package query;

import query.field.CollectionField;
import query.field.DateField;
import query.field.Field;
import query.field.IntegerField;
import query.field.StringField;
import query.function.IntegerFunctions;

public class MemberFinderTemplate<RootFinderClass extends AbstractFinder> extends AbstractFinder {

    private RootFinderClass rootFinder;
    
    public MemberFinderTemplate() {
    }

    public MemberFinderTemplate(RootFinderClass rootFinder) {
        this.rootFinder = rootFinder;
    }

    protected void setRootFinder(RootFinderClass rootFinder) {
        this.rootFinder = rootFinder;
    }

    public MemberFinderTemplate<RootFinderClass> memberNumber(String memberNumber) {
        return memberNumber().eq(memberNumber);
    }

    public StringField<MemberFinderTemplate<RootFinderClass>> memberNumber() {
        return new StringField<MemberFinderTemplate<RootFinderClass>>(this, "memberNumber");
    }

    public MemberFinderTemplate<RootFinderClass> firstName(String firstName) {
        return firstName().eq(firstName);
    }

    public StringField<MemberFinderTemplate<RootFinderClass>> firstName() {
        return new StringField<MemberFinderTemplate<RootFinderClass>>(this, "firstName");
    }

    public StringField<MemberFinderTemplate<RootFinderClass>> lastName() {
        return new StringField<MemberFinderTemplate<RootFinderClass>>(this, "lastName");
    }

    public StringField<MemberFinderTemplate<RootFinderClass>> fullName() {
        return firstName().concat(lastName());
    }

    public DateField<MemberFinderTemplate<RootFinderClass>> suspectAddressDate() {
        return new DateField<MemberFinderTemplate<RootFinderClass>>(this, "suspectAddressDate");
    }

    public MemberFinderTemplate<RootFinderClass> hasSuspectAddress() {
        return suspectAddressDate().isNotEmpty();
    }

    public CollectionField<
            MemberFinderTemplate<RootFinderClass>,
            MemberPartnerLinkFinderTemplate<RootFinderClass>,
            MemberPartnerLinkFinderTemplate<MemberPartnerLinkFinder>
            > memberPartnerLinks() {

        return new CollectionField<
                MemberFinderTemplate<RootFinderClass>,
                MemberPartnerLinkFinderTemplate<RootFinderClass>,
                MemberPartnerLinkFinderTemplate<MemberPartnerLinkFinder>
                >
            (
                    this,
                    new MemberPartnerLinkFinderTemplate<RootFinderClass>(),
                    new MemberPartnerLinkFinder(),
                    "memberPartnerLinks");
    }

    public MemberFinderTemplate<RootFinderClass> isLinkedTo(String licenseeNumber) {

        // Option 1
        memberPartnerLinks().containsElementWith().partner().licenseeNumber().eq(licenseeNumber);
        //return this;
        // note that .root() return RootFinderClass instead of MemberFinderTemplate<RootFinderClass> which is consistent across the whole DSL
        // TODO - how to go back to access memberPartnerLink ? parent()? NOTE: If we don't support this syntax it cannot do one liner
        // with multiple criteria on memberPartnerLink
        // TODO - do we need a way to reference back the MemberFinderTemplate<RootFinderClass>? We could call 'return this' here
        // but for DAO layers it can't reference it if needed. However this is a general problem anyway so doesn't seem to be needed
        //return this;

        // Option 2
        return memberPartnerLinks().contains(memberPartnerLinks().element().partner().licenseeNumber().eq(licenseeNumber).root());
    }
    
    public CollectionField<MemberFinderTemplate<RootFinderClass>, AdjustmentTemplate<RootFinderClass>, AdjustmentTemplate<AdjustmentFinder>> adjustments() {
        return new CollectionField<MemberFinderTemplate<RootFinderClass>, AdjustmentTemplate<RootFinderClass>, AdjustmentTemplate<AdjustmentFinder>>
            (this, new AdjustmentTemplate<RootFinderClass>(), new AdjustmentFinder(), "adjustments");
    }

    public CollectionField<MemberFinderTemplate<RootFinderClass>, RedemptionTemplate<RootFinderClass>, RedemptionTemplate<RedemptionFinder>> redemptions() {
        return new CollectionField<MemberFinderTemplate<RootFinderClass>, RedemptionTemplate<RootFinderClass>, RedemptionTemplate<RedemptionFinder>>
            (this, new RedemptionTemplate<RootFinderClass>(), new RedemptionFinder(), "redemptions");
    }

    public MemberPartnerLinkFinderTemplate<RootFinderClass> oldestLinkOfLicensee(String licenseeNumber) {        
        return memberPartnerLinks().elementWithMaxOf(
                memberPartnerLinks().element().licenseeNumber(licenseeNumber).isActive(),
                memberPartnerLinks().element().startDate());
    }

    public CollectionField oldestLinksPerLicensee() {
        return memberPartnerLinks().elementsWithMaxOf(
                memberPartnerLinks().element().isActive(),
                new Field[] {memberPartnerLinks().element().startDate()},
                new Field[] {memberPartnerLinks().element().partner().licenseeNumber()});
    }

    public IntegerField<MemberFinderTemplate<RootFinderClass>> nettPoints() {

        IntegerField<MemberFinderTemplate<RootFinderClass>> unprocessedCreditAdjustmentPoints =
        
                adjustments().sumOf(
                    adjustments().element().points().negate(),
                    adjustments().element().proccessed().eq("N").type().eq("11"));

        IntegerField<MemberFinderTemplate<RootFinderClass>> unprocessedDebitAdjustmentPoints =
                
                adjustments().sumOf(
                    adjustments().element().points(),
                    adjustments().element().proccessed().eq("N").type().eq("22"));


        IntegerField<MemberFinderTemplate<RootFinderClass>> unprocessedRedemptions =
                
                redemptions().sumOf(
                        redemptions().element().points(),
                        redemptions().element().status().eq("3"));

        return IntegerFunctions.add(
                unprocessedCreditAdjustmentPoints,
                unprocessedDebitAdjustmentPoints,
                unprocessedRedemptions);
    }

    public RootFinderClass root() {
        return rootFinder;
    }

    public MemberFinderTemplate<RootFinderClass> and() {
        return this;
    }

    public MemberFinderTemplate<RootFinderClass> or() {
        return this;
    }

    public MemberFinderTemplate<RootFinderClass> openBracket() {
        return this;
    }

    public MemberFinderTemplate<RootFinderClass> closeBracket() {
        return this;
    }
}

