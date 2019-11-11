package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    Queue queue() {
        return new Queue("TestQueue", false);
    }

    @RabbitListener(queues = "TestQueue")
    public void processMessage(String message) {
        log.info("Rabbitmq-receive Massage (from TestQueue) :::: {}", message);
    }

    @RabbitListener(queues = "Test2Queue")
    public void processMessage2(String message) throws InterruptedException {
        log.info("Rabbitmq-receive Massage (from Test2Queue) :::: {}", message);
    }
}
