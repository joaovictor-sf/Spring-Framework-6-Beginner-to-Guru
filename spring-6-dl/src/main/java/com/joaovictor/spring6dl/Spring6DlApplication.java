package com.joaovictor.spring6dl;

import com.joaovictor.spring6dl.controller.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring6DlApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Spring6DlApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		System.out.println("No metodo main");
		System.out.println(controller.hello());
	}

}
