package com.wincom.dbsyncagent.tasks;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.wincom.dbsyncagent.tasks.vo.VodBuyCancelVO;
import com.wincom.dbsyncagent.tasks.vo.VodBuyVO;

@Service
public interface dbSyncTaskService {
	
	//DB #1
	public String getDBTime() throws Exception;
	public List<VodBuyCancelVO> vodBuyCancelList() throws Exception;
	public void updateVodCancelTbl(VodBuyCancelVO vodcancelitem) throws Exception;
	public void insertVodCancelTbl(VodBuyCancelVO vodcancelitem) throws Exception;
}
