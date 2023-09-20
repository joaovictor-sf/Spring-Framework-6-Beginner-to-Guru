package com.joaovictor.spring6dl.service.r18n;

import com.joaovictor.spring6dl.service.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("PT")
@Service("i18NService")
public class PortugueseGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Olá Mundo - PT";
    }
}
