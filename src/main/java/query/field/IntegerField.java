package query.field;

import query.AbstractFinder;
import query.function.Add;
import query.function.Function;
import query.function.Negate;

public class IntegerField<CurrentFinderClass extends AbstractFinder> implements Field<CurrentFinderClass> {

    private CurrentFinderClass currentFinder;
    private String fieldName;
    
    public IntegerField(CurrentFinderClass currentFinder, String fieldName) {
        this.currentFinder = currentFinder;
        this.fieldName = fieldName;
    }

    public IntegerField(CurrentFinderClass currentFinder, Function function) {
        this.currentFinder = currentFinder;
    }

    public CurrentFinderClass getCurrentFinder() {
        return currentFinder;
    }

    public CurrentFinderClass eq(Integer value) {
        return currentFinder;
    }

    public CurrentFinderClass gt(Integer string) {
        return currentFinder;
    }

    public CurrentFinderClass lt(Integer string) {
        return currentFinder;
    }

    public IntegerField<CurrentFinderClass> negate() {
        return new IntegerField<CurrentFinderClass>(currentFinder, new Negate(fieldName));
    }

    public IntegerField<CurrentFinderClass> add(IntegerField<CurrentFinderClass> another) {
        return new IntegerField<CurrentFinderClass>(currentFinder, new Add(fieldName, another.fieldName));
    }
}
