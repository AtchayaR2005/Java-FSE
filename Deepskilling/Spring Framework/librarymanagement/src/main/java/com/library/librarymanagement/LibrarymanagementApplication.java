package com.library.librarymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.library")
public class LibrarymanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibrarymanagementApplication.class, args);
    }
}
