package br.com.robson.strconsumer.exceptions;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {


    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        log.info("EXCEPTION_HANDLER ::: Capturei um Error");
        log.info("Payload ::: {}", message.getPayload());
        log.info("Headers ::: {}", message.getHeaders());
        log.info("Offset ::: {}", message.getHeaders().get("kafka_offset"));
        log.info("Message Exception ::: {}", exception.getMessage());
        return null;
    }
}
