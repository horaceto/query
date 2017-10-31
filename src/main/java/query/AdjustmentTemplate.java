package query;

import query.field.IntegerField;
import query.field.StringField;


public class AdjustmentTemplate<RootFinderClass extends AbstractFinder> extends AbstractFinder {

    private RootFinderClass rootFinder;

    public AdjustmentTemplate() {
    }

    public AdjustmentTemplate(RootFinderClass rootFinder) {
        this.rootFinder = rootFinder;
    }

    protected void setRootFinder(RootFinderClass rootFinder) {
        this.rootFinder = rootFinder;
    }

    public StringField<AdjustmentTemplate<RootFinderClass>> type() {
        return new StringField<AdjustmentTemplate<RootFinderClass>>(this, "type");
    }

    public StringField<AdjustmentTemplate<RootFinderClass>> proccessed() {
        return new StringField<AdjustmentTemplate<RootFinderClass>>(this, "proccessed");
    }

    public IntegerField<AdjustmentTemplate<RootFinderClass>> points() {
        return new IntegerField<AdjustmentTemplate<RootFinderClass>>(this, "points");
    }
    
    public RootFinderClass root() {
        return rootFinder;
    }

    public AdjustmentTemplate<RootFinderClass> and() {
        return this;
    }

    public AdjustmentTemplate<RootFinderClass> or() {
        return this;
    }

    public AdjustmentTemplate<RootFinderClass> openBracket() {
        return this;
    }

    public AdjustmentTemplate<RootFinderClass> closeBracket() {
        return this;
    }
}

