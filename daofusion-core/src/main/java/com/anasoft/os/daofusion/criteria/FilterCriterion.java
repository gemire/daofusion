package com.anasoft.os.daofusion.criteria;

import org.hibernate.criterion.Criterion;

/**
 * Filter criterion for a single property of the target
 * persistent entity.
 * 
 * <p>
 * 
 * The filter criterion uses the {@link PropertyFilterCriterionProvider}
 * instance to construct a {@link Criterion} instance corresponding
 * to the given property of the target persistent entity.
 * 
 * <p>
 * 
 * There are basically two ways to pass data (filter values)
 * to the {@link PropertyFilterCriterionProvider} instance:
 * 
 * <ul>
 *  <li>by specifying <tt>filterObjectValuePaths</tt> - array of
 *  	dot-separated logical paths pointing to values reachable
 *  	from the root filter object
 *  <li>by specifying <tt>directValues</tt> - array of objects
 *  	provided directly by the user
 * </ul>
 * 
 * It is therefore possible to combine the filter object and direct
 * value concepts together to suit individual filter criterion needs.
 * 
 * @see PropertyFilterCriterionProvider
 * @see NestedPropertyCriterion
 * 
 * @author vojtech.szocs
 */
public class FilterCriterion extends NestedPropertyCriterion {

    private final String[] filterObjectValuePaths;
    private final Object[] directValues;
    
    private final PropertyFilterCriterionProvider filterCriterionProvider;
    
    /**
     * Creates a new filter criterion.
     * 
     * @param propertyPath Dot-separated logical path to the target property.
     * @param associationJoinType Type of join to use in case of a nested
     * (non-direct) persistent entity property (can be <tt>null</tt> otherwise).
     * @param filterObjectValuePaths Array of dot-separated logical paths
     * pointing to values reachable from the root filter object (can be <tt>null</tt>).
     * @param directValues Array of filter values provided directly by the user
     * (can be <tt>null</tt>).
     * @param filterCriterionProvider Custom {@link PropertyFilterCriterionProvider}
     * implementation.
     */
    public FilterCriterion(String propertyPath, NestedPropertyJoinType associationJoinType, String[] filterObjectValuePaths, Object[] directValues, PropertyFilterCriterionProvider filterCriterionProvider) {
        super(propertyPath, associationJoinType);
        
        this.filterObjectValuePaths = filterObjectValuePaths;
        this.directValues = directValues;
        this.filterCriterionProvider = filterCriterionProvider;
    }
    
    /**
     * Creates a new filter criterion using the default nested persistent entity
     * property join type.
     * 
     * @param propertyPath Dot-separated logical path to the target property.
     * @param filterObjectValuePaths Array of dot-separated logical paths
     * pointing to values reachable from the root filter object (can be <tt>null</tt>).
     * @param directValues Array of filter values provided directly by the user
     * (can be <tt>null</tt>).
     * @param filterCriterionProvider Custom {@link PropertyFilterCriterionProvider}
     * implementation.
     */
    public FilterCriterion(String propertyPath, String[] filterObjectValuePaths, Object[] directValues, PropertyFilterCriterionProvider filterCriterionProvider) {
    	this(propertyPath, NestedPropertyJoinType.DEFAULT, filterObjectValuePaths, directValues, filterCriterionProvider);
    }
    
    /**
     * Creates a new filter criterion.
     * 
     * <p>
     * 
     * This is a convenience constructor supporting single filter object value path
     * or a single direct value, depending on <tt>useFilterObjectPathResolution</tt>.
     * 
     * @param propertyPath Dot-separated logical path to the target property.
     * @param associationJoinType Type of join to use in case of a nested
     * (non-direct) persistent entity property (can be <tt>null</tt> otherwise).
     * @param value Dot-separated logical path pointing to a value reachable
     * from the root filter object OR a direct value provided by the
     * user.
     * @param useFilterObjectPathResolution <tt>true</tt> to treat <tt>value</tt>
     * as a filter object value path, <tt>false</tt> to treat <tt>value</tt> as
     * a direct value provided by the user.
     * @param filterCriterionProvider Custom {@link PropertyFilterCriterionProvider}
     * implementation.
     */
    public FilterCriterion(String propertyPath, NestedPropertyJoinType associationJoinType, Object value, boolean useFilterObjectPathResolution, PropertyFilterCriterionProvider filterCriterionProvider) {
        this(propertyPath, associationJoinType, useFilterObjectPathResolution ? new String[] { (String) value } : null, useFilterObjectPathResolution ? null : new Object[] { value }, filterCriterionProvider);
    }
    
    /**
     * Creates a new filter criterion using the default nested persistent entity
     * property join type.
     * 
     * <p>
     * 
     * This is a convenience constructor supporting single filter object value path
     * or a single direct value, depending on <tt>useFilterObjectPathResolution</tt>.
     * 
     * @param propertyPath Dot-separated logical path to the target property.
     * @param value Dot-separated logical path pointing to a value reachable
     * from the root filter object OR a direct value provided by the
     * user.
     * @param useFilterObjectPathResolution <tt>true</tt> to treat <tt>value</tt>
     * as a filter object value path, <tt>false</tt> to treat <tt>value</tt> as
     * a direct value provided by the user.
     * @param filterCriterionProvider Custom {@link PropertyFilterCriterionProvider}
     * implementation.
     */
    public FilterCriterion(String propertyPath, Object value, boolean useFilterObjectPathResolution, PropertyFilterCriterionProvider filterCriterionProvider) {
        this(propertyPath, NestedPropertyJoinType.DEFAULT, value, useFilterObjectPathResolution, filterCriterionProvider);
    }
    
    /**
     * @return Array of dot-separated logical paths pointing to values
     * reachable from the root filter object (can be <tt>null</tt>).
     */
    public String[] getFilterObjectValuePaths() {
        return filterObjectValuePaths;
    }
    
    /**
     * @return Array of filter values provided directly by the user
     * (can be <tt>null</tt>).
     */
    public Object[] getDirectValues() {
        return directValues;
    }
    
    /**
     * @return Custom {@link PropertyFilterCriterionProvider}
     * implementation.
     */
    public PropertyFilterCriterionProvider getFilterCriterionProvider() {
        return filterCriterionProvider;
    }
    
	/**
	 * @see com.anasoft.os.daofusion.criteria.NestedPropertyCriterion#accept(com.anasoft.os.daofusion.criteria.NestedPropertyCriterionVisitor)
	 */
	@Override
	public void accept(NestedPropertyCriterionVisitor visitor) {
		visitor.visit(this);
	}
    
}
