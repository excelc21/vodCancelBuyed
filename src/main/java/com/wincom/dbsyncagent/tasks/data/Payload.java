package com.wincom.dbsyncagent.tasks.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload<T> implements Serializable {

    // 메시지 고유 아이디
    private String messageId;

    // 메시지 유형
    private String messageType;

    // 메시지 생성 일시
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "Asia/Seoul")
    private LocalDateTime messageCreatedDt;

    // 메시지 본문
    @SuppressWarnings("squid:S1948")
    private T messageBody;

    public Payload(T messageBody) {
        this.messageId = UUID.randomUUID().toString();
        this.messageCreatedDt = LocalDateTime.now();
        this.messageBody = messageBody;
    }

    public Payload(String messageType, T messageBody) {
        this(messageBody);
        this.messageType = messageType;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getMessageType() {
        return messageType;
    }

    public LocalDateTime getMessageCreatedDt() {
        return messageCreatedDt;
    }

    public T getMessageBody() {
        return messageBody;
    }
}
