package sddtc.explore.java.design.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sddtc on 2017/1/18.
 */
public class BaseFactory {
    private Map<String, Class<? extends UniverseInfo>> map;

    public BaseFactory() {
        map = new HashMap<>();
        map.put("Sun", SunInfo.class);
    }

    public UniverseInfo create(String name) {
        Class<? extends UniverseInfo> c = map.get(name);
        UniverseInfo universeInfo = null;

        try {
            universeInfo = c.newInstance();
        } catch (Exception ex) {

        }

        return universeInfo;
    }

}
