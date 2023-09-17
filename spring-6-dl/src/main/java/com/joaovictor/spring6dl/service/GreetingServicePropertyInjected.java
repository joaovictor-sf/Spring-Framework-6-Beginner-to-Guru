package com.joaovictor.spring6dl.service;

import org.springframework.stereotype.Service;

@Service("propertyGreetingService")
public class GreetingServicePropertyInjected implements GreetingService{
    @Override
    public String sayGreeting() {
        return "proprerty injected greeting service";
    }
}
