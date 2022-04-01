package com.wincom.dbsyncagent.config.kafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

@SuppressWarnings("deprecation")
public interface ProducerChannel {

    String SAMPLE_OUT = "sample-out";

    @Output(SAMPLE_OUT)
    MessageChannel sampleOut();

}
