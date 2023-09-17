package com.joaovictor.spring6dl.controller;

import org.junit.jupiter.api.Test;

public class MyControllerTest {

    @Test
    void sayHello() {
        MyController myController = new MyController();

        System.out.println(myController.hello());
    }
}
