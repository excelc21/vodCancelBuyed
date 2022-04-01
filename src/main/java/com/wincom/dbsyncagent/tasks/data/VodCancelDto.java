package com.wincom.dbsyncagent.tasks.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VodCancelDto {

    private String entrId;      //PVS_SBC_CONT_NO
    private String stbMacAddr;  //PVS_MAC_ADDR
    private String useStrtDttm; //PVS_BUY_DATE
    private String udrGrpNo;    //UDR_GRP_NO
    private String udrGrpSno;   //UDR_GRP_SEQ_NO
    private String udrGrpCnt;   //UDR_GRP_CNT
    private String tvCntsCd;    //CNTS_CD
    private String iptvStlmRtngKdCd;    //RATE_TYP_CD
    private String cnclDttm;    //PVS_CANCEL_DATE
    private String cnclWorkYn;  //PROCESS_FLAG

}
