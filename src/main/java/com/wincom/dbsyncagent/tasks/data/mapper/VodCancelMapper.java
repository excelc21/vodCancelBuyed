package com.wincom.dbsyncagent.tasks.data.mapper;


import com.wincom.dbsyncagent.config.kafka.ObjectMapperConfig;
import com.wincom.dbsyncagent.tasks.data.RdAlbumInfoDto;
import com.wincom.dbsyncagent.tasks.data.VodCancelDto;
import com.wincom.dbsyncagent.tasks.vo.VodBuyCancelVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = ObjectMapperConfig.class)
public interface VodCancelMapper {

    @Mapping(target = "pvs_sbc_cont_no", source = "entrId")
    @Mapping(target = "pvs_mac_addr", source = "stbMacAddr")
    @Mapping(target = "buy_date", source = "useStrtDttm")
    @Mapping(target = "udr_grp_no", source = "udrGrpNo")
    @Mapping(target = "udr_grp_seq_no", source = "udrGrpSno")
    @Mapping(target = "udr_grp_cnt", source = "udrGrpCnt")
    @Mapping(target = "cnts_cd", source = "tvCntsCd")
    @Mapping(target = "rate_typ_cd", source = "iptvStlmRtngKdCd")
    @Mapping(target = "pvs_cancel_date", source = "cnclDttm")
    @Mapping(target = "process_flag", source = "cnclWorkYn")
    VodBuyCancelVO toEntity(VodCancelDto dto);
}
