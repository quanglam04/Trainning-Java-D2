package com.example.EX_26;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex26Application implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(Ex26Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Ex26Application.class, args);
    }

    @Override
    public void run(String... args) {
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warning message");
        logger.error("Error message");
        logger.info("Log4j2 test: Đây là một dòng log để kiểm tra file logs/app.log");
    }
}
