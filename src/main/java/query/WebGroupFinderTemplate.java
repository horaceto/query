package query;

import query.field.StringField;

public class WebGroupFinderTemplate<RootFinderClass extends AbstractFinder> extends AbstractFinder {

    private RootFinderClass rootFinder;

    public WebGroupFinderTemplate() {
    }

    public WebGroupFinderTemplate(RootFinderClass rootFinder) {
        this.rootFinder = rootFinder;
    }

    protected void setRootFinder(RootFinderClass rootFinder) {
        this.rootFinder = rootFinder;
    }

    public WebGroupFinderTemplate<RootFinderClass> webGroupCode(String webGroupCode) {
        return webGroupCode().eq(webGroupCode);
    }

    public StringField<WebGroupFinderTemplate<RootFinderClass>> webGroupCode() {
        return new StringField<WebGroupFinderTemplate<RootFinderClass>>(this, "webGroupCode");
    }

    public RootFinderClass root() {
        return rootFinder;
    }

    public WebGroupFinderTemplate<RootFinderClass> and() {
        return this;
    }

    public WebGroupFinderTemplate<RootFinderClass> or() {
        return this;
    }

    public WebGroupFinderTemplate<RootFinderClass> openBracket() {
        return this;
    }

    public WebGroupFinderTemplate<RootFinderClass> closeBracket() {
        return this;
    }
}

