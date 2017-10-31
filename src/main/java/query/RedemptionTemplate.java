package query;

import query.field.IntegerField;
import query.field.StringField;


public class RedemptionTemplate<RootFinderClass extends AbstractFinder> extends AbstractFinder {

    private RootFinderClass rootFinder;

    public RedemptionTemplate() {
    }

    public RedemptionTemplate(RootFinderClass rootFinder) {
        this.rootFinder = rootFinder;
    }

    protected void setRootFinder(RootFinderClass rootFinder) {
        this.rootFinder = rootFinder;
    }

    public StringField<RedemptionTemplate<RootFinderClass>> status() {
        return new StringField<RedemptionTemplate<RootFinderClass>>(this, "status");
    }

    public IntegerField<RedemptionTemplate<RootFinderClass>> points() {
        return new IntegerField<RedemptionTemplate<RootFinderClass>>(this, "points");
    }
    
    public RootFinderClass root() {
        return rootFinder;
    }

    public RedemptionTemplate<RootFinderClass> and() {
        return this;
    }

    public RedemptionTemplate<RootFinderClass> or() {
        return this;
    }

    public RedemptionTemplate<RootFinderClass> openBracket() {
        return this;
    }

    public RedemptionTemplate<RootFinderClass> closeBracket() {
        return this;
    }
}

