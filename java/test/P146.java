package test;

import java.util.LinkedHashMap;

/**
 * 实现一个LRU缓存
 */
public class P146 {
class LRUCache {

    int capacity;

    LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

    public LRUCache(int capacity) {
      this.capacity =  capacity;
    }

    public int get(int key) {
        if (linkedHashMap.containsKey(key)) {
            //更新顺序
            Integer value = linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
            return;
        }
        if (linkedHashMap.size() >= this.capacity) {
            int oldestKey = linkedHashMap.keySet().iterator().next(); //这个地方是找到队头，队头是最早未访问的元素
            linkedHashMap.remove(oldestKey);
        }
        linkedHashMap.put(key, value);
    }

}
}
