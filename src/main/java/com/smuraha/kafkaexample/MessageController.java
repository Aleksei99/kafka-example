package com.smuraha.kafkaexample;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaTemplate<String,Message> kafkaTemplate;

    @PostMapping
    public void publish(@RequestBody MessageRequest request){
        Message message = new Message(request.message(), LocalDateTime.now());
        kafkaTemplate.send("myTopic",message);
    }

}
