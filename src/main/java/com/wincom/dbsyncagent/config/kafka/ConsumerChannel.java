package com.wincom.dbsyncagent.config.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

@SuppressWarnings("deprecation")
public interface ConsumerChannel {

    String SAMPLE_IN = "sample-in";
    String DLQ_SAMPLE_IN = "dlq-sample-in";

    String BPAS_ADMIN_IN = "bpas-admin-in";
    String DLQ_BPAS_ADMIN_IN = "dlq-bpas-admin-in";

    @Input(SAMPLE_IN)
    SubscribableChannel sampleIn();

    @Input(DLQ_SAMPLE_IN)
    SubscribableChannel dlqSampleIn();

    @Input(BPAS_ADMIN_IN)
    SubscribableChannel bpasAdminIn();

    @Input(DLQ_BPAS_ADMIN_IN)
    SubscribableChannel dlqBpasAdminIn();

}
