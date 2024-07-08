package br.com.robson.strconsumer.listeners;

import br.com.robson.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;
@Log4j2
@Component
public class StrConsumerListener {
    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message){
        log.info("CREATE ::: Mensagem Recebida: {}", message);
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message){
        log.info("LOG ::: Mensagem Recebida: {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "srtContainerFactory")
    public void history(String message){
        log.info("LOG ::: Mensagem Recebida: {}", message);
    }
}
