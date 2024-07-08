package br.com.robson.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("str-topic", message).whenComplete(
                (result, e) -> {
                    if (result != null) {
                        log.info("Mensagem enviada com sucesso {}", result);
                        log.info("Partition: {}, offSet: {}", result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset());
                    } else {
                        if(e != null) {
                            log.info("Erro ao enviar mensagem: {}", e.getCause());
                        }
                    }
                }
        );
    }

}
