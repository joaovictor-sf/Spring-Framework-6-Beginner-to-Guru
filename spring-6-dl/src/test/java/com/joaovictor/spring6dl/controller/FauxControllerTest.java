package com.joaovictor.spring6dl.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles({"prod", "EN"})
@SpringBootTest
class FauxControllerTest {
    // Adicionar "EN" é necessario

    @Autowired
    FauxController fauxController;
    @Test
    void sayData() {
        System.out.println(fauxController.sayData());
    }
}