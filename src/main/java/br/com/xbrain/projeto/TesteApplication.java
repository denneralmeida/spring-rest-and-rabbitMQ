package br.com.xbrain.projeto;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TesteApplication {

    @Value("${queue.order.name}")
    private String pedidosFila;

    public static void main(String[] args) {
        SpringApplication.run(TesteApplication.class, args);
    }

    @Bean
    public Queue queue() {
        return new Queue(pedidosFila, true);
    }

}
