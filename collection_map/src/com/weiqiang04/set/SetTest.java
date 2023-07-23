package com.weiqiang04.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest {

    @Test
    public void test1() {
        Set set = new HashSet();

        set.add("AA");
        set.add(123);
        set.add("BB");
        set.add(new Person("tom", 12));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2() {
        Set set = new LinkedHashSet();

        set.add("AA");
        set.add(123);
        set.add("BB");
        set.add(new Person("tom", 12));
        set.add(new Person("tom", 12));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
