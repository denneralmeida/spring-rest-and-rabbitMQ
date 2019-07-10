package br.com.xbrain.projeto.service.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class AmqpTemplate {

    @Autowired
    private RabbitTemplate template;

    @Value("${queue.name}")
    private String orderName;

    public void produceMessage(Object msg) {
        template.convertAndSend(orderName, msg);
    }

    @Bean
    Queue queue() {
        return new Queue(orderName, true);
    }
}

