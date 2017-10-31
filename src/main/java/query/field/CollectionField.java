package query.field;

import query.AbstractFinder;
import query.function.Sum;

public class CollectionField<CurrentFinderClass extends AbstractFinder,
                             ElementFinderClass extends AbstractFinder,
                             ElementFinderClassAsRoot extends AbstractFinder> {

    private CurrentFinderClass currentFinder;
    private String fieldName;
    private ElementFinderClass elementFinder;
    private ElementFinderClassAsRoot elementFinderAsRoot;
    
    public CollectionField(CurrentFinderClass currentFinder, ElementFinderClass elementFinder,
            ElementFinderClassAsRoot elementFinderAsRoot, String fieldName) {
        this.currentFinder = currentFinder;
        this.elementFinder = elementFinder;
        this.elementFinderAsRoot = elementFinderAsRoot;
        this.fieldName = fieldName;
    }

    public IntegerField<CurrentFinderClass> size() {
        return new IntegerField<CurrentFinderClass>(currentFinder, "size");
    }

    public ElementFinderClass containsElementWith() {
        // TODO - create a new instance? as long as a new instance is created it should be safe and could support
        // multiple containsElementWith() and notContainsElementWith() in one query
        // TODO - should we still keep this? Would it be confusing?
        // TODO - to support one liner syntax further works need to be done. Refer to MemberFinderTemplate.isLinkedTo for details
        return elementFinder;
    }

    public ElementFinderClass notContainsElementWith() {
        // TODO - create a new instance?
        // TODO - should we still keep this? Would it be confusing?
        return elementFinder;
    }

    public CurrentFinderClass contains(ElementFinderClassAsRoot elementCriteria) {

        return currentFinder;
    }

    public CurrentFinderClass isEmpty() {

        return currentFinder;
    }

    public CurrentFinderClass notContains(ElementFinderClassAsRoot elementCriteria) {

        return currentFinder;
    }

    public CurrentFinderClass containsOnly(ElementFinderClassAsRoot elementCriteria) {

        return currentFinder;
    }

    public CurrentFinderClass notContainsOnly(ElementFinderClassAsRoot elementCriteria) {

        return currentFinder;
    }

    public ElementFinderClass elementWithMaxOf(
            ElementFinderClassAsRoot filter,
            Field... fields) {
        
        try {
            return (ElementFinderClass) elementFinder.getClass().newInstance();
        }catch (Exception e) {
            throw new RuntimeException("Fail to create new class");
        }
    }

    public CollectionField<CurrentFinderClass, ElementFinderClass, ElementFinderClassAsRoot> elementsWithMaxOf(
            ElementFinderClassAsRoot filter,
            Field[] maxFields,
            Field[] groupByFields) {

        try {
            return (CollectionField<CurrentFinderClass, ElementFinderClass, ElementFinderClassAsRoot>) this.getClass().newInstance();
        }catch (Exception e) {
            throw new RuntimeException("Fail to create new class");
        }
    }

    public ElementFinderClassAsRoot element() {
        try {
            return (ElementFinderClassAsRoot) elementFinderAsRoot.getClass().newInstance();
        }catch (Exception e) {
            throw new RuntimeException("Fail to create new class");
        }
    }

    public IntegerField<CurrentFinderClass> sumOf(
            IntegerField<ElementFinderClassAsRoot> integerField,
            ElementFinderClassAsRoot filter) {

        return new IntegerField<CurrentFinderClass>(currentFinder, new Sum(this, integerField, filter));
    }
}
