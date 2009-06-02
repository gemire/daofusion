package com.anasoft.os.daofusion.cto.server;

import com.anasoft.os.daofusion.criteria.AssociationPath;
import com.anasoft.os.daofusion.criteria.FilterCriterion;
import com.anasoft.os.daofusion.criteria.NestedPropertyCriteria;
import com.anasoft.os.daofusion.criteria.NestedPropertyJoinType;
import com.anasoft.os.daofusion.criteria.PropertyFilterCriterionProvider;
import com.anasoft.os.daofusion.criteria.SortCriterion;
import com.anasoft.os.daofusion.cto.client.FilterAndSortCriteria;

/**
 * Criteria transfer object mapping regarding the <em>filtering</em>
 * and <em>sorting</em> functionality.
 * 
 * <p>
 * 
 * This mapping uses a {@link FilterValueObjectProvider} instance
 * to construct typed object representations of string-based filter
 * values received from the {@link FilterAndSortCriteria} (these
 * objects will be passed as <tt>directValues</tt> to the underlying
 * {@link FilterCriterion} instances in case the <tt>filterCriterionProvider</tt>
 * is not <tt>null</tt>, indicating that the filtering functionality
 * is enabled).
 * 
 * @see FilterValueObjectProvider
 * @see PropertyFilterCriterionProvider
 * @see NestedPropertyMapping
 * 
 * @author vojtech.szocs
 */
public class FilterAndSortMapping extends NestedPropertyMapping {

	private final PropertyFilterCriterionProvider filterCriterionProvider;
	private final FilterValueObjectProvider filterValueObjectProvider;
	
	/**
	 * Creates a new property mapping.
	 * 
	 * @deprecated <tt>propertyPath</tt> / <tt>associationJoinType</tt> concept
     * is now deprecated in favor of the <tt>associationPath</tt> / <tt>targetPropertyName</tt>
     * approach.
	 * 
	 * @param propertyId Symbolic persistent entity property identifier.
	 * @param propertyPath Dot-separated logical path to the target property.
	 * @param associationJoinType Type of join to use in case of a nested
     * (non-direct) persistent entity property (can be <tt>null</tt> otherwise).
	 * @param filterCriterionProvider Custom {@link PropertyFilterCriterionProvider}
     * implementation or <tt>null</tt> to disable the filtering functionality.
     * @param filterValueObjectProvider Custom {@link FilterValueObjectProvider}
     * implementation (applicable only when the <tt>filterCriterionProvider</tt>
     * is not <tt>null</tt>).
	 */
	@Deprecated
	public FilterAndSortMapping(String propertyId, String propertyPath, NestedPropertyJoinType associationJoinType, PropertyFilterCriterionProvider filterCriterionProvider, FilterValueObjectProvider filterValueObjectProvider) {
		super(propertyId, propertyPath, associationJoinType);
		
		this.filterCriterionProvider = filterCriterionProvider;
		this.filterValueObjectProvider = filterValueObjectProvider;
	}
	
	/**
	 * Creates a new property mapping.
	 * 
     * @param propertyId Symbolic persistent entity property identifier.
     * @param associationPath {@link AssociationPath} which points
     * to the given property of the target persistent entity.
     * @param targetPropertyName Name of the target property of
     * the given persistent entity.
     * @param filterCriterionProvider Custom {@link PropertyFilterCriterionProvider}
     * implementation or <tt>null</tt> to disable the filtering functionality.
     * @param filterValueObjectProvider Custom {@link FilterValueObjectProvider}
     * implementation (applicable only when the <tt>filterCriterionProvider</tt>
     * is not <tt>null</tt>).
	 */
	public FilterAndSortMapping(String propertyId, AssociationPath associationPath, String targetPropertyName, PropertyFilterCriterionProvider filterCriterionProvider, FilterValueObjectProvider filterValueObjectProvider) {
	    super(propertyId, associationPath, targetPropertyName);
	    
        this.filterCriterionProvider = filterCriterionProvider;
        this.filterValueObjectProvider = filterValueObjectProvider;
	}
	
	/**
	 * Creates a new property mapping using the default
	 * nested persistent entity property join type.
	 * 
	 * @deprecated <tt>propertyPath</tt> / <tt>associationJoinType</tt> concept
     * is now deprecated in favor of the <tt>associationPath</tt> / <tt>targetPropertyName</tt>
     * approach.
	 * 
	 * @param propertyId Symbolic persistent entity property identifier.
	 * @param propertyPath Dot-separated logical path to the target property.
	 * @param filterCriterionProvider Custom {@link PropertyFilterCriterionProvider}
     * implementation or <tt>null</tt> to disable the filtering functionality.
     * @param filterValueObjectProvider Custom {@link FilterValueObjectProvider}
     * implementation (applicable only when the <tt>filterCriterionProvider</tt>
     * is not <tt>null</tt>).
	 */
	@Deprecated
	public FilterAndSortMapping(String propertyId, String propertyPath, PropertyFilterCriterionProvider filterCriterionProvider, FilterValueObjectProvider filterValueObjectProvider) {
		this(propertyId, propertyPath, NestedPropertyJoinType.DEFAULT, filterCriterionProvider, filterValueObjectProvider);
	}
	
	/**
	 * Creates a new property mapping.
	 * 
	 * <p>
	 * 
	 * This is a convenience constructor for mappings
	 * which don't require the filtering functionality.
	 * 
	 * @deprecated <tt>propertyPath</tt> / <tt>associationJoinType</tt> concept
     * is now deprecated in favor of the <tt>associationPath</tt> / <tt>targetPropertyName</tt>
     * approach.
	 * 
	 * @param propertyId Symbolic persistent entity property identifier.
	 * @param propertyPath Dot-separated logical path to the target property.
	 * @param associationJoinType Type of join to use in case of a nested
     * (non-direct) persistent entity property (can be <tt>null</tt> otherwise).
	 */
	@Deprecated
	public FilterAndSortMapping(String propertyId, String propertyPath, NestedPropertyJoinType associationJoinType) {
		this(propertyId, propertyPath, associationJoinType, null, null);
	}
	
	/**
	 * Creates a new property mapping.
     * 
     * <p>
     * 
     * This is a convenience constructor for mappings
     * which don't require the filtering functionality.
	 * 
     * @param propertyId Symbolic persistent entity property identifier.
     * @param associationPath {@link AssociationPath} which points
     * to the given property of the target persistent entity.
     * @param targetPropertyName Name of the target property of
     * the given persistent entity.
	 */
	public FilterAndSortMapping(String propertyId, AssociationPath associationPath, String targetPropertyName) {
	    this(propertyId, associationPath, targetPropertyName, null, null);
	}
	
	/**
	 * Creates a new property mapping using the default
	 * nested persistent entity property join type.
	 * 
	 * <p>
	 * 
	 * This is a convenience constructor for mappings
	 * which don't require the filtering functionality.
	 * 
	 * @deprecated <tt>propertyPath</tt> / <tt>associationJoinType</tt> concept
     * is now deprecated in favor of the <tt>associationPath</tt> / <tt>targetPropertyName</tt>
     * approach.
	 * 
	 * @param propertyId Symbolic persistent entity property identifier.
	 * @param propertyPath Dot-separated logical path to the target property.
	 */
	@Deprecated
	public FilterAndSortMapping(String propertyId, String propertyPath) {
		this(propertyId, propertyPath, null, null);
	}
	
	/**
	 * @return Custom {@link PropertyFilterCriterionProvider} implementation
	 * or <tt>null</tt> to disable the filtering functionality.
	 */
	public PropertyFilterCriterionProvider getFilterCriterionProvider() {
		return filterCriterionProvider;
	}
	
	/**
	 * @return Custom {@link FilterValueObjectProvider} implementation
	 * (applicable only when the <tt>filterCriterionProvider</tt> is not
	 * <tt>null</tt>).
	 */
	public FilterValueObjectProvider getFilterValueObjectProvider() {
		return filterValueObjectProvider;
	}
	
	/**
	 * @see com.anasoft.os.daofusion.cto.server.NestedPropertyMapping#apply(com.anasoft.os.daofusion.cto.client.FilterAndSortCriteria, com.anasoft.os.daofusion.criteria.NestedPropertyCriteria)
	 */
	@Override
	public void apply(FilterAndSortCriteria clientSideCriteria, NestedPropertyCriteria serverSideCriteria) {
		if (filterCriterionProvider != null && clientSideCriteria.getFilterValues().length > 0) {
			serverSideCriteria.add(getFilterCriterion(clientSideCriteria));
		}
		
		if (clientSideCriteria.getSortAscending() != null) {
			serverSideCriteria.add(getSortCriterion(clientSideCriteria));
		}
	}
	
	/**
	 * Returns a {@link FilterCriterion} instance built
	 * from the <tt>clientSideCriteria</tt>.
	 * 
	 * @param clientSideCriteria Client-side persistent entity
	 * criteria representation.
	 * @return Resulting {@link FilterCriterion} instance.
	 */
	private FilterCriterion getFilterCriterion(FilterAndSortCriteria clientSideCriteria) {
		String[] stringFilterValues = clientSideCriteria.getFilterValues();
		Object[] typedFilterValues = new Object[stringFilterValues.length];
		
		// convert string-based filter values into their typed representations
		for (int i = 0; i < stringFilterValues.length; i++) {
			typedFilterValues[i] = filterValueObjectProvider.getObject(stringFilterValues[i]);
		}
		
		return new FilterCriterion(getAssociationPath(),
				getTargetPropertyName(),
				null,
				typedFilterValues,
				filterCriterionProvider);
	}
	
	/**
	 * Returns a {@link SortCriterion} instance built
	 * from the <tt>clientSideCriteria</tt>.
	 * 
	 * @param clientSideCriteria Client-side persistent entity
	 * criteria representation.
	 * @return Resulting {@link SortCriterion} instance.
	 */
	private SortCriterion getSortCriterion(FilterAndSortCriteria clientSideCriteria) {
		boolean sortAscending = clientSideCriteria.getSortAscending() != null ? clientSideCriteria.getSortAscending().booleanValue() : false;
		boolean ignoreCase = clientSideCriteria.getIgnoreCase() != null ? clientSideCriteria.getIgnoreCase().booleanValue() : false;
		
		return new SortCriterion(getAssociationPath(),
				getTargetPropertyName(),
				sortAscending,
				ignoreCase);
	}
	
}
