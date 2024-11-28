package com.johan99999.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication (scanBasePackages = "com.johan99999.todolist")
public class ToDoListApiCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApiCrudApplication.class, args);
	}

}
