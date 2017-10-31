package query.field;

import java.util.Date;

import query.AbstractFinder;

public class DateField<CurrentFinderClass extends AbstractFinder> implements Field<CurrentFinderClass> {

    private CurrentFinderClass currentFinder;
    private String fieldName;
    
    public DateField(CurrentFinderClass rootFinder, String fieldName) {
        this.currentFinder = rootFinder;
        this.fieldName = fieldName;
    }

    public CurrentFinderClass before(Date value) {
        return currentFinder;
    }

    public CurrentFinderClass after(Date value) {
        return currentFinder;
    }

    public CurrentFinderClass isEmpty() {
        return currentFinder;
    }

    public CurrentFinderClass isNotEmpty() {
        return currentFinder;
    }
}
