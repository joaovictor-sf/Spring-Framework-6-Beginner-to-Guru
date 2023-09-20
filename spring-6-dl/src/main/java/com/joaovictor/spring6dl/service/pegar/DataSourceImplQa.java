package com.joaovictor.spring6dl.service.pegar;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("qa")
@Service
public class DataSourceImplQa implements DataSource {
    @Override
    public String getData() {
        return "I'm the QA datasource";
    }
}
