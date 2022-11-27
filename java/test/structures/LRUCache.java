package test.structures;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

//第一中写法
public class LRUCache extends LinkedHashMap {
    private final int CACHE_SIZE;

    public LRUCache(int CACHE_SIZE) {
        super((int)Math.ceil(CACHE_SIZE / 0.75) + 1,0.75f, true);
        this.CACHE_SIZE = CACHE_SIZE;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > CACHE_SIZE;
    }
}
//第二个写法
class TimeOutInfoHolder{}
class LRUCache2 {
    final Map<Long, TimeOutInfoHolder> timeOutInfoHolder = Collections.synchronizedMap(new LinkedHashMap<Long, TimeOutInfoHolder>(100, .75F, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Long, TimeOutInfoHolder> eldest) {
            return size() > 100;
        }
    });
}
