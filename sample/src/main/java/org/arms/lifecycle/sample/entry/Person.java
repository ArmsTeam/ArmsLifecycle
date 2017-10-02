package org.arms.lifecycle.sample.entry;

import java.util.Locale;

/**
 * Created by ArmsTeam on 2017/10/2.
 */

public class Person {
    public final String name;
    public final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(Locale.CHINESE,
                "Person ---> name: %s, age: %d", name, age);
    }
}
