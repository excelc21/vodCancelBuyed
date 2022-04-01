package com.wincom.dbsyncagent.tasks.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wincom.dbsyncagent.config.kafka.ConsumerChannel;
import com.wincom.dbsyncagent.tasks.data.IptvBuyCncldRootDto;
import com.wincom.dbsyncagent.tasks.data.Payload;
import com.wincom.dbsyncagent.tasks.data.VodCancelDto;
import com.wincom.dbsyncagent.tasks.data.mapper.VodCancelMapper;
import com.wincom.dbsyncagent.tasks.dbSyncTaskServiceImpl;
import com.wincom.dbsyncagent.tasks.vo.VodBuyCancelVO;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import static com.wincom.dbsyncagent.config.kafka.KafkaConstants.VOD_CANCEL_MESSAGETYPE;

/**
 * 메시지 구독
 */
@SuppressWarnings("deprecation")
@Slf4j
@RequiredArgsConstructor
@EnableBinding(ConsumerChannel.class)
public class IptvBuyCncldConsumer {

    private final ObjectMapper objectMapper;
    private final dbSyncTaskServiceImpl dbSyncService;
    private final VodCancelMapper mapper;

    /**
     * 메시지 타입이 'test-inserted'인 메시지 구독
     */
    @SneakyThrows
    @StreamListener(value = "bpas-admin-in")
    public void receive(@Header("x-message-type") String messageType, byte[] messages) {

            String message = new String(messages, StandardCharsets.UTF_8);
            log.info(">>> message sub, message: {}", message);

            if (VOD_CANCEL_MESSAGETYPE.equals(messageType)) {
                Payload<VodCancelDto> payload = this.objectMapper.readValue(messages, new TypeReference<>() {
                });
                log.debug(">>> IptvBuyCncldRootDto: {}", payload.getMessageBody());
                // 위에서 주입한 presentation 레이어 클래스의 메소드 호출
                VodCancelDto vodCancelDto = payload.getMessageBody();

                dbSyncService.insertVodCancelTbl(this.mapper.toEntity(vodCancelDto));

            }

    }

}
