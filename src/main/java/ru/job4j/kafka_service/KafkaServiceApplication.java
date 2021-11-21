package ru.job4j.kafka_service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
@SpringBootApplication
public class KafkaServiceApplication {

    @KafkaListener(topics = {"pasport"})
    public void msgListener(ConsumerRecord<String, String> input) {
        System.out.println("accepting " + input.key());
        System.out.println(input.value());
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaServiceApplication.class, args);
    }

}
