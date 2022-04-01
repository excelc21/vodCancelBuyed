package com.wincom.dbsyncagent.config.kafka;

public class KafkaConstants {

    private KafkaConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String DEFAULT_TOPIC_NAME = "bpas-admin";
    public static final String VODPROGRAMMING_TOPIC_NAME = "bpas-admin.VodProgramming";
    public static final String PURCHASING_TOPIC_NAME = "bpas-admin.Purchasing";
    public static final String PRODUCT_TOPIC_NAME = "bpas-admin.Product";
    public static final String CHANNEL_TOPIC_NAME = "bpas-admin.Channel";

    public static final String ALBUM_INFO_SAVE_MESSAGETYPE = "rd_vl_album_info.save";
    public static final String ALBUM_INFO_DELETE_MESSAGETYPE = "rd_vl_album_info.delete";

    public static final String VOD_CANCEL_MESSAGETYPE = "vodCancel.save";

}
