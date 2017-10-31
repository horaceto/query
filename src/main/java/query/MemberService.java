package query;

public class MemberService {

    public static void main(String[] args) {

        MemberFinder memberFinder = new MemberFinder();
        memberFinder.memberNumber("30000000").and()
            .openBracket()
                .firstName("TEST").or().lastName().like("abc")
            .closeBracket();
    }

    public static void example2() {
        MemberFinder memberFinder = new MemberFinder();
        memberFinder
            .memberNumber().eq("30000000")
            .and()
            .openBracket()
                .firstName("TEST").or().lastName().like("abc")
            .closeBracket();
    }

   /*
        AND
            Equal(MemberNumber, 30000000)
            OR
                Equal(FirstName, TEST)
                Like(lastName, abc)
            
    * 
    */

    public static void example3_1() {
        MemberPartnerLinkFinder memberPartnerLinkFinder = new MemberPartnerLinkFinder();

        memberPartnerLinkFinder
            .isActive()
            .member().memberNumber("30000000")
            .root().partner().licenseeNumber("950").isActive();

        // OR Embedded fully:

        memberPartnerLinkFinder.activeLinksForMemberAndPartner("30000000", "950");

        // OR Embedded partially by creating shortcuts to child attributes so
        // that any combinations are supported

        memberPartnerLinkFinder.isActive().memberNumber("30000000").licenseeNumber("950");

        memberPartnerLinkFinder.isActiveAndDisplayableOnWebsiteLinksPage("30000000");
    }

    public static void example3_2() {
        MemberPartnerLinkFinder memberPartnerLinkFinder = new MemberPartnerLinkFinder();

        // Embedded fully:

        memberPartnerLinkFinder.isActiveAndDisplayableOnWebsiteLinksPage("30000000");
    }

    public static void example4() {
        PartnerFinder partnerFinder
            = new PartnerFinder();

        partnerFinder
            .licenseeNumber("950");
    }

    public static void example5() {
        MemberFinder memberFinder = new MemberFinder();
        memberFinder
            .memberNumber().eq("30000000")
            .memberPartnerLinks().size().gt(1);
    }

    public static void example6() {
        MemberFinder memberFinder = new MemberFinder();

        memberFinder
            .memberNumber().eq("30000000")
            .memberPartnerLinks().containsElementWith().partner().licenseeNumber().eq("440");

        // OR Simplified

        memberFinder
            .memberNumber().eq("30000000").isLinkedTo("440");

        // OR Simplified

        memberFinder.memberNumber("30000000").isLinkedTo("440");

        String memberNumber = "30000000";
        String licenseeNumber = "440";
/*
 *      TODO
        if (memberFinder.memberNumber(memberNumber).isLinkedTo(licenseeNumber)) {
            
        }
*/
    }

    public static void example7WithSummation() {
        MemberFinder memberFinder = new MemberFinder();

        memberFinder.nettPoints().gt(2000).hasSuspectAddress();

    }

    public static void example8WithElementsWithMaxOf() {
        MemberFinder memberFinder = new MemberFinder();

        memberFinder.oldestLinksPerLicensee();

    }
}
