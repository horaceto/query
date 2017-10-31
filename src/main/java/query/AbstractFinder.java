package query;

import java.util.Map;
import java.util.Stack;

public class AbstractFinder {
    protected Map criteria;

    protected Stack conditions;
    public void addCriteria(String name, String value) {
        criteria.put(name, value);
    }

}
