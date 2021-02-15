package com.sda.functional.streams.op_intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DemoSorted {

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("alex", 30),
                new User("dan", 40),
                new User("ana", 10),
                new User("vali", 20),
                new User("cristina", 50));

        /*
            List<User> sortedList = users.stream()
            .sorted((o1, o2) -> o1.getAge() - o2.getAge())
            .collect(Collectors.toList());
        */

        List<User> reverseSortedUsers = users.stream()
                .sorted(Comparator.comparingInt(User::getAge).reversed())
                .collect(Collectors.toList());

        reverseSortedUsers.forEach(System.out::println);
    }

    static class User {

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
