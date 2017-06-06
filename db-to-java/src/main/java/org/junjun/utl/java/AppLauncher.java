package org.junjun.utl.java;

import org.junjun.util.java.service.ReverseEngineService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AppLauncher {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(AppLauncher.class, args);
		ReverseEngineService service = ctx.getBean(ReverseEngineService.class);
		service.databaseToJava();
		ctx.close();
		System.exit(0);
	}
}
