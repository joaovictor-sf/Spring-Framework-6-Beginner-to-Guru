package com.joaovictor.spring6dl;

import com.joaovictor.spring6dl.controller.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class Spring6DlApplicationTests {

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
