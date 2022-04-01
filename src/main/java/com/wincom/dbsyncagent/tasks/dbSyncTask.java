package com.wincom.dbsyncagent.tasks;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wincom.dbsyncagent.tasks.vo.VodBuyCancelVO;
import com.wincom.dbsyncagent.tasks.vo.VodBuyVO;

@Component
public class dbSyncTask {
	
	private static final Logger log = LoggerFactory.getLogger("dbSyncTask");
	
	@Autowired
	dbSyncTaskServiceImpl dbSyncService;
	
	public void executeJob() throws Exception {
	    //System.out.println("DB #1시간:"+ dbSyncService.getDBTime());
	    
	    List<VodBuyCancelVO> cancellist = dbSyncService.vodBuyCancelList();
	    log.info("구매취소 요청 갯수: {} ", cancellist.size());
	    
	    for (VodBuyCancelVO citem : cancellist) {
	    	
	    	log.info("구매취소 정보: {}, {}, {}, {} ", citem.getPvs_sbc_cont_no(), citem.getPvs_mac_addr(), citem.getBuy_date(), citem.getCnts_cd());
	    	
//	    	List<VodBuyVO> vodbuylist = dbSyncService.vodBuyList(citem);
//	    	//log.info("구매 목록 갯수: {} ", vodbuylist.size());
//
//	    	if (vodbuylist.size() > 0 && vodbuylist.get(0).getSa_id().equals("1")) {
//	    		//log.info("처리항목임: {}, Err_msg:{}, Err_msg_null_chk:{} ", vodbuylist.get(0).getSa_id(), vodbuylist.get(0).getErr_msg(), vodbuylist.get(0).getErr_msg_null_chk());
//
//	    		if (vodbuylist.get(0).getErr_msg_null_chk().equals("Y")) {
//	    			citem.setError_msg("X|X||X|");
//	    		} else {
//	    			citem.setError_msg(vodbuylist.get(0).getError_msg() + "X|");
//	    		}
//
//	    		//PT_VO_BUY 업데이트(VODUSER.PT_VO_BUY.ERROR_MSG 컬럼)
//	    		dbSyncService.updateVodBuy(citem);
//	    		log.info("[step1] 구매취소 업데이트 (VODUSER.PT_VO_BUY.ERROR_MSG): {}, {}, {}, {} ", citem.getPvs_sbc_cont_no(), citem.getPvs_mac_addr(), citem.getBuy_date(), citem.getCnts_cd(), citem.getError_msg());
//	    	}
//
//	    	dbSyncService.updateVodCancelTbl(citem);
//	    	log.info("[step2] 구매취소 업데이트(PVSUSER.XCION_VOD_CANCEL_TBL): {}, {}, {}, {} ", citem.getPvs_sbc_cont_no(), citem.getPvs_mac_addr(), citem.getBuy_date(), citem.getCnts_cd());
//
	    }
	}
}
