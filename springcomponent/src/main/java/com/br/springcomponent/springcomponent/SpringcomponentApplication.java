package com.br.springcomponent.springcomponent;

import com.br.springcomponent.springcomponent.controller.MyController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringcomponentApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringcomponentApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		controller.hello();

	}

}
