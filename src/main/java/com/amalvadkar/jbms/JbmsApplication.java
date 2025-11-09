package com.amalvadkar.jbms;

import com.amalvadkar.jbms.adapter.out.BookmarkStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(BookmarkStore.class)
public class JbmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JbmsApplication.class, args);
	}

}
