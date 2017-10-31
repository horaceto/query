package query;

import query.field.StringField;


public class PartnerFinderTemplate<RootFinderClass extends AbstractFinder> extends AbstractFinder {

    private RootFinderClass rootFinder;

    public PartnerFinderTemplate() {
    }

    public PartnerFinderTemplate(RootFinderClass rootFinder) {
        this.rootFinder = rootFinder;
    }

    protected void setRootFinder(RootFinderClass rootFinder) {
        this.rootFinder = rootFinder;
    }

    public PartnerFinderTemplate<RootFinderClass> licenseeNumber(String licenseeNumber) {
        return licenseeNumber().eq(licenseeNumber);
    }

    public PartnerFinderTemplate<RootFinderClass> isActive() {
        return new StringField<PartnerFinderTemplate<RootFinderClass>>(this, "isActive").eq("true");
    }

    public StringField<PartnerFinderTemplate<RootFinderClass>> licenseeNumber() {
        return new StringField<PartnerFinderTemplate<RootFinderClass>>(this, "licenseeNumber");
    }

    public WebGroupFinderTemplate<RootFinderClass> webGroup() {
        return new WebGroupFinderTemplate<RootFinderClass>(rootFinder);
    }

    public PartnerFinderTemplate<RootFinderClass> isLDisplayableOnWebsiteLinksPage() {
        isActive().licenseeNumber().ne("425").webGroup().webGroupCode().ne("OTH");
        return this;
    }

    public RootFinderClass root() {
        return rootFinder;
    }

    public PartnerFinderTemplate<RootFinderClass> and() {
        return this;
    }

    public PartnerFinderTemplate<RootFinderClass> or() {
        return this;
    }

    public PartnerFinderTemplate<RootFinderClass> openBracket() {
        return this;
    }

    public PartnerFinderTemplate<RootFinderClass> closeBracket() {
        return this;
    }
}

