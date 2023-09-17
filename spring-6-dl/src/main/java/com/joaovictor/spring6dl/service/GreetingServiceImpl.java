package com.joaovictor.spring6dl.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Ola todo mundo, estou no service";
    }
}
