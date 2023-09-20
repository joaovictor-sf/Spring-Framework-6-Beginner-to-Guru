package com.joaovictor.spring6dl.service.pegar;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("uat")
@Service
public class DataSourceImplUat implements DataSource {
    @Override
    public String getData() {
        return "I'm the UAT datasource";
    }
}
