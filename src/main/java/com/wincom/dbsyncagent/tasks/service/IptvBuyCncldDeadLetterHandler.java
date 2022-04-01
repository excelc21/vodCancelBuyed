package com.wincom.dbsyncagent.tasks.service;

import com.wincom.dbsyncagent.config.kafka.ConsumerChannel;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

@SuppressWarnings("deprecation")
@Slf4j
@RequiredArgsConstructor
@EnableBinding(ConsumerChannel.class)
public class IptvBuyCncldDeadLetterHandler {


    /**
     * dead letter 로깅 & 핸들링
     *
     * @param topic
     * @param consumerGroup
     * @param error
     * @param payload
     */
    @StreamListener(value = ConsumerChannel.DLQ_BPAS_ADMIN_IN)
    public void handleDeadLetter(@Header(KafkaHeaders.RECEIVED_TOPIC) String topic
        , @Header(KafkaHeaders.GROUP_ID) String consumerGroup
        , @Header("x-exception-message") byte[] error
        , @Header("x-message-type") String messageType
        , byte[] payload
    ) {
        // 모든 로그는 EFK에 저장되므로, 아래 로그 또한 EFK에 저장된다.
        log.error(">>> bpas-admin dlq\ntopic: {}\nconsumerGroup: {}\nmessageType: {}\nerror: {}\npayload: {}"
            , topic
            , consumerGroup
            , messageType
            , new String(error, StandardCharsets.UTF_8)
            , new String(payload, StandardCharsets.UTF_8)
        );
    }

}
