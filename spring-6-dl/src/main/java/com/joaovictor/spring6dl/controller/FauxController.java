package com.joaovictor.spring6dl.controller;

import com.joaovictor.spring6dl.service.pegar.DataSource;
import org.springframework.stereotype.Controller;

@Controller
public class FauxController {
    private final DataSource dataSource;

    public FauxController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String sayData() {
        return dataSource.getData();
    }
}
