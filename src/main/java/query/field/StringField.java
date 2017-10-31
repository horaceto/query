package query.field;

import query.AbstractFinder;

public class StringField<CurrentFinderClass extends AbstractFinder> implements Field<CurrentFinderClass> {

    private CurrentFinderClass currentFinder;
    private String fieldName;
    
    public StringField(CurrentFinderClass currentFinder,
                        String fieldName) {

        this.currentFinder = currentFinder;
        this.fieldName = fieldName;
    }

    public StringField(CurrentFinderClass currentFinder,
            String fuctionName,
            String fieldName1,
            String fieldName2) {        
    }

    public CurrentFinderClass eq(String value) {
        return currentFinder;
    }

    public CurrentFinderClass ne(String value) {
        return currentFinder;
    }

    public CurrentFinderClass like(String string) {
        return currentFinder;
    }

    public StringField<CurrentFinderClass> concat(StringField<CurrentFinderClass> another) {
        return new StringField<CurrentFinderClass>(currentFinder, "concat", fieldName, another.fieldName);
    }
}
