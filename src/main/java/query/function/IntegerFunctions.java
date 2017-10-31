package query.function;

import query.AbstractFinder;
import query.field.IntegerField;


public class IntegerFunctions {

    public static <CurrentFinderClass extends AbstractFinder> IntegerField<CurrentFinderClass> add(
            IntegerField<CurrentFinderClass>... fields) {

        return new IntegerField<CurrentFinderClass>(fields[0].getCurrentFinder(), new Add(fields));
    }
}
