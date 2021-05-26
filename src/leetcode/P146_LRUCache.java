package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author egbz
 * @date 2021/5/26
 */
public class P146_LRUCache {
    LinkedHashMap<Integer, Integer> map;

    public P146_LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        Integer ans = map.get(key);
        return ans != null ? ans : -1;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public static void main(String[] args) {
        P146_LRUCache instance = new P146_LRUCache(2);
        instance.put(1, 1);
        instance.put(2, 2);
        System.out.println(instance.get(1));
        instance.put(3,3);
        System.out.println(instance.get(2));
        instance.put(4,4);
        System.out.println(instance.get(1));
        System.out.println(instance.get(3));
        System.out.println(instance.get(4));

    }


}
