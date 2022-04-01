package com.wincom.dbsyncagent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ImportResource("classpath:spring/root-context.xml")
public class vodCancelBuyedApp {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(vodCancelBuyedApp.class);
    }
	
	public static void main(String[] args) {

    	SpringApplication application = new SpringApplication(vodCancelBuyedApp.class);
    	application.addListeners(new ApplicationPidFileWriter());
    	application.run(args);
    	
		System.out.println("Kafka Agent Start!!");
	}

}
