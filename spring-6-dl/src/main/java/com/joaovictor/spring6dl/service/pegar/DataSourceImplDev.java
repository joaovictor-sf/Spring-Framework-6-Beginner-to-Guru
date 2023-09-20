package com.joaovictor.spring6dl.service.pegar;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"dev", "default"})
@Service
public class DataSourceImplDev implements DataSource {
    @Override
    public String getData() {
        return "I'm the development datasource";
    }
}
