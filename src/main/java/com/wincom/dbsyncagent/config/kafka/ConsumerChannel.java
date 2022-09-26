package com.wincom.dbsyncagent.config.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

@SuppressWarnings("deprecation")
public interface ConsumerChannel {

    String BPAS_ADMIN_IN = "bpas-admin-in";
    String DLQ_BPAS_ADMIN_IN = "dlq-bpas-admin-in";


    @Input(BPAS_ADMIN_IN)
    SubscribableChannel bpasAdminIn();

    @Input(DLQ_BPAS_ADMIN_IN)
    SubscribableChannel dlqBpasAdminIn();

}
