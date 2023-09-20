package com.joaovictor.spring6dl.service.pegar;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("prod")
@Service
public class DataSourceImplProd implements DataSource {
    @Override
    public String getData() {
        return "I'm the PROD datasource";
    }
}
