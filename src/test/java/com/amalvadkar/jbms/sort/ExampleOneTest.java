package com.amalvadkar.jbms.sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ExampleOneTest {

    @Test
    void returnCatsWithAgeDescOrder  () {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("pari",25,54));
        cats.add(new Cat("kari",24,76));
        cats.add(new Cat("tari",50,79));
        ExampleOne exampleOne = new ExampleOne();

        List<Cat> result =  exampleOne.sort(cats);
        assertThat(result.getFirst().getAge()).isEqualTo(25);

    }
}
