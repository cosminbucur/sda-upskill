package com.sda.concurrency.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Concurrent collections (e.g. ConcurrentHashMap), achieve thread-safety by dividing their
 * data into segments. In a ConcurrentHashMap, for example, different threads can acquire
 * locks on each segment, so multiple threads can access the Map at the same time
 * (a.k.a. concurrent access).
 */
// https://howtodoinjava.com/java/multi-threading/best-practices-for-using-concurrenthashmap/
// https://www.java67.com/2020/02/25-examples-of-concurrenthashmap-in-java.html
class ConcurrentMapTest {

    // create
    // in concurrent hash map you have: forEachKey() and search()
    private ConcurrentMap<Item, Integer> usualMap = new ConcurrentHashMap<>();

    private ConcurrentHashMap<Item, Integer> map = new ConcurrentHashMap<>();
    private Item tv = new Item(1L, "tv", 200);
    private Item phone = new Item(2L, "phone", 100);

    @BeforeEach
    void setUp() {
        // add
        map.put(tv, 5);
        map.put(phone, 8);
    }

    @Test
    void concurrentHashMap() throws Exception {
        // - add

        // - iterate

//
//        // if you want to iterate, you have to sync the list
//        Runnable task = () -> {
//
//        };
//
//        Thread thread1 = new Thread(task);
//        Thread thread2 = new Thread(task);
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//
//        assertThat(map).hasSize(6);
    }

    @Test
    void addMap() {
        // does not support null
        Assertions.assertThrows(NullPointerException.class, () ->
                map.put(null, 80)
        );
        System.out.println(map);
    }

    @Test
    void readMap() {
        // - get an item that doesn't exist
        // uses hashcode, must implement equals and hashcode
        Item car = new Item(3L, "car", 4000);
        Integer nonExistingValue = map.get(car);
        assertThat(nonExistingValue).isNull();

        // - size
        int size = map.size();
        assertThat(size).isEqualTo(2);
    }

    @Test
    void updateMap() {
        // many threads can access it at once
        Integer oldTvValue = map.get(tv);
        Integer newTvValue = 9;
        map.replace(tv, oldTvValue, newTvValue);
        System.out.println("after update " + map);
        assertThat(map.get(tv)).isEqualTo(newTvValue);
    }

    @Test
    void iterateMap() {
        System.out.println("enhanced for");
        for (Map.Entry<Item, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        System.out.println("for each");
        map.forEach((item, votes) -> System.out.println(item + "=" + votes));

        System.out.println("for each entry");
        map.forEachEntry(2, System.out::println);

        System.out.println("for each key");
        map.forEachKey(2, System.out::println);

        System.out.println("for each value");
        map.forEachValue(2, System.out::println);

        System.out.println("key set");
        map.keySet().getMappedValue();
    }


}