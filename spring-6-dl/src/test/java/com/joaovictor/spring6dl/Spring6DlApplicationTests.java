package com.joaovictor.spring6dl;

import com.joaovictor.spring6dl.controller.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class Spring6DlApplicationTests {
	// Dependency Injection (DI) is a technique whereby one object (or static method) supplies the dependencies of another object.
	// é muito usado para testes
	// @Autowired is a Spring annotation which acts as a request to Spring to inject a dependency.

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	MyController myController;

	@Test
	void testAutowiredOfController() {
		System.out.println(myController.hello());
	}

	@Test
	void testGetControllerFromContext() {
		MyController controller = (MyController) applicationContext.getBean("myController");

		System.out.println(controller.hello());
	}

	@Test
	void contextLoads() {
	}

}
