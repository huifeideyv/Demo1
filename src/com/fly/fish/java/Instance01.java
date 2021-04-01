package com.fly.fish.java;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class Instance01 {
    public static void main(String[] args) {
        //泛型类
        Person<Integer, String> person = new Person<>(001, "yangxingugo");
        System.out.println(person.getName());
        person.show2("123456");
        Person.show1(123);
    }

    static class Person<T, V> {
        private T Id;
        private V name;

        public Person() {
        }

        public Person(T id, V name) {
            this.Id = id;
            this.name = name;
        }

        public T getId() {
            return Id;
        }

        public void setId(T id) {
            Id = id;
        }

        public V getName() {
            return name;
        }

        public void setName(V name) {
            this.name = name;
        }

        /*
        静态方法定义的泛型与类无关
         */
        public static <E> void show1(E age) {
            System.out.println("的年龄为：" + age);
        }

        /*
        普通方法也可独立定义泛型
         */
        public <E> void show2(E age) {
            System.out.println("的年龄为：" + age);
        }
    }
}
