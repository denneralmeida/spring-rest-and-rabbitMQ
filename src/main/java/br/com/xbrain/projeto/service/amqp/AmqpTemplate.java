package br.com.xbrain.projeto.service.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AmqpTemplate {

    @Autowired
    private RabbitTemplate template;

    @Value("${queue.order.name}")
    private String orderName;

    public void produceMessage(String msg) {
        template.convertAndSend(orderName, msg);
        System.out.println("Enviado..." + msg);
    }


    Queue queue() {
        return new Queue(orderName, false);
    }
}

