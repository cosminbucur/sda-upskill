package com.sda.concurrency.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

// https://www.baeldung.com/java-synchronized-collections
class SynchronizedCollectionTest {

    @Test
    void synchronizedCollection() throws Exception {
        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());

        Runnable task = () ->
                syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5));

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        assertThat(syncCollection).hasSize(10);
    }

    @Test
    void synchronizedList() throws Exception {
        List<String> syncList = Collections.synchronizedList(Arrays.asList("a", "b", "c"));
        List<String> newCollection = new ArrayList<>();

        // if you want to iterate, you have to sync the list
        Runnable task = () -> {
            synchronized (syncList) {
                syncList.forEach(element ->
                        newCollection.add(element.toUpperCase()));
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        assertThat(newCollection).hasSize(6);
        assertThat(newCollection.get(5)).isEqualTo("C");
    }

    @Test
    void synchronizedMap() throws Exception {
        Map<Integer, String> syncMap = Collections.synchronizedMap(new HashMap<>());

        List<String> names = List.of("alex", "ana", "paul");

        // if you want to iterate, you have to sync the list
        Runnable task = () -> {
            synchronized (syncMap) {
                for (int i = 0; i <= names.size(); i++) {
                    System.out.println(Thread.currentThread().getName());
                    syncMap.put(i, names.get(i));
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        assertThat(syncMap).hasSize(6);
        assertThat(syncMap.get(5)).isEqualTo("C");
    }

    @Test
    void synchronizedSortedMap() throws Exception {
        Map<Integer, String> syncSortedMap = Collections.synchronizedSortedMap(new TreeMap<>());

        List<String> names = List.of("alex", "ana", "paul");

        // if you want to iterate, you have to sync the list
        Runnable task = () -> {
            synchronized (syncSortedMap) {
                for (int i = 0; i <= names.size(); i++) {
                    syncSortedMap.put(i, names.get(i));
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        assertThat(syncSortedMap).hasSize(3);
        assertThat(syncSortedMap.get(5)).isEqualTo("C");
    }

    @Test
    void synchronizedSet() throws Exception {
        Set<Integer> syncSet = Collections.synchronizedSet(new HashSet<>());
        Set<Integer> newSet = new HashSet<>();

        List<Integer> numbers = List.of(1, 2, 3);

        // if you want to iterate, you have to sync the list
        Runnable task = () -> {
            synchronized (syncSet) {
                newSet.addAll(numbers);
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        assertThat(newSet).hasSize(3);
    }

    @Test
    void synchronizedSortedSet() throws Exception {
        Set<Integer> syncSortedSet = Collections.synchronizedSortedSet(new TreeSet<>());

        List<Integer> numbers = List.of(1, 2, 3);

        // if you want to iterate, you have to sync the list
        Runnable listOperations = () -> {
            synchronized (syncSortedSet) {
                for (int i = 0; i <= numbers.size(); i++) {
                    syncSortedSet.add(numbers.get(i));
                }
            }
        };

        Thread thread1 = new Thread(listOperations);
        Thread thread2 = new Thread(listOperations);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        assertThat(syncSortedSet).hasSize(6);
    }

}