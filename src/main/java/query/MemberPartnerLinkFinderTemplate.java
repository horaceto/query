package query;

import java.util.Date;

import query.field.DateField;

public class MemberPartnerLinkFinderTemplate<RootFinderClass extends AbstractFinder> extends AbstractFinder {

    private RootFinderClass rootFinder;

    public MemberPartnerLinkFinderTemplate() {
    }

    public MemberPartnerLinkFinderTemplate(RootFinderClass rootFinder) {
        this.rootFinder = rootFinder;
    }

    protected void setRootFinder(RootFinderClass rootFinder) {
        this.rootFinder = rootFinder;
    }

    public MemberFinderTemplate<RootFinderClass> member() {
        return new MemberFinderTemplate<RootFinderClass>(rootFinder);
    }

    public PartnerFinderTemplate<RootFinderClass> partner() {
        return new PartnerFinderTemplate<RootFinderClass>(rootFinder);
    }

    public DateField<MemberPartnerLinkFinderTemplate<RootFinderClass>> startDate() {
        return new DateField<MemberPartnerLinkFinderTemplate<RootFinderClass>>(this, "startDate");
    }

    public DateField<MemberPartnerLinkFinderTemplate<RootFinderClass>> endDate() {
        return new DateField<MemberPartnerLinkFinderTemplate<RootFinderClass>>(this, "endDate");
    }

    public MemberPartnerLinkFinderTemplate<RootFinderClass> isActive() {
        return startDate().before(new Date())
                .openBracket().
                    endDate().isEmpty().or().endDate().after(new Date())
                .closeBracket();
    }

    public MemberPartnerLinkFinderTemplate<RootFinderClass> isActiveAndDisplayableOnWebsiteLinksPage(String memberNumber) {

        member().memberNumber(memberNumber);
        partner().isLDisplayableOnWebsiteLinksPage();
        isActive();
        return this;
    }

    public MemberPartnerLinkFinderTemplate<RootFinderClass> activeLinksForMemberAndPartner(String memberNumber, String licenseeNumber) {

        member().memberNumber(memberNumber);
        partner().licenseeNumber(licenseeNumber);
        isActive();
        return this;
    }

    // Shortcut to child attributes
    public MemberPartnerLinkFinderTemplate<RootFinderClass> licenseeNumber(String licenseeNumber) {

        partner().licenseeNumber(licenseeNumber);
        return this;
    }

    // Shortcut to child attributes
    public MemberPartnerLinkFinderTemplate<RootFinderClass> memberNumber(String memberNumber) {

        member().memberNumber(memberNumber);
        return this;
    }

    public RootFinderClass root() {
        return rootFinder;
    }

    public MemberPartnerLinkFinderTemplate<RootFinderClass> and() {
        return this;
    }

    public MemberPartnerLinkFinderTemplate<RootFinderClass> or() {
        return this;
    }

    public MemberPartnerLinkFinderTemplate<RootFinderClass> openBracket() {
        return this;
    }

    public MemberPartnerLinkFinderTemplate<RootFinderClass> closeBracket() {
        return this;
    }
}

