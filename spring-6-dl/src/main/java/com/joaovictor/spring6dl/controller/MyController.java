package com.joaovictor.spring6dl.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

        public String hello() {
            System.out.println("Hello World!");

            return "Testando o controller";
        }
}
