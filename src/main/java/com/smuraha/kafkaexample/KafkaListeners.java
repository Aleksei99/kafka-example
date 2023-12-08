package com.smuraha.kafkaexample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "myTopic",
            groupId = "groupId",
            containerFactory = "factory"
    )
    void listener(Message data) {
        System.out.println("Listener Received: " + data + " !!!");
    }

}
