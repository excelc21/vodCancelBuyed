package com.wincom.dbsyncagent.tasks.dao1;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.wincom.dbsyncagent.tasks.vo.VodBuyCancelVO;
import com.wincom.dbsyncagent.tasks.vo.VodBuyVO;

@Repository
public interface Db1Mapper {
	
	public String getDBTime() throws Exception;
	public List<VodBuyCancelVO> vodBuyCancelList() throws Exception;
	public List<VodBuyVO> vodBuyList(VodBuyCancelVO vodcancelitem) throws Exception;
	
	public void updateVodBuy(VodBuyCancelVO vodcancelitem) throws Exception;
	public void updateVodCancelTbl(VodBuyCancelVO vodcancelitem) throws Exception;
	public void insertVodCancelTbl(VodBuyCancelVO vodcancelitem) throws Exception;
}
