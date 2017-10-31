package query;

public class MemberFinder extends MemberFinderTemplate<MemberFinder> {

    public MemberFinder() {
       super();
       setRootFinder(this);
    }
}
