package com.wincom.dbsyncagent.tasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.wincom.dbsyncagent.tasks.dao1.Db1Mapper;
import com.wincom.dbsyncagent.tasks.vo.VodBuyCancelVO;
import com.wincom.dbsyncagent.tasks.vo.VodBuyVO;

@Repository
public class dbSyncTaskServiceImpl implements dbSyncTaskService {
	
	@Autowired
	Db1Mapper db1SyncDao;


	public String getDBTime() throws Exception {
		return db1SyncDao.getDBTime();
	}
	
	public List<VodBuyCancelVO> vodBuyCancelList() throws Exception {
		
		List<VodBuyCancelVO> cancellist = db1SyncDao.vodBuyCancelList();
		return cancellist;
	}

	public void updateVodCancelTbl(VodBuyCancelVO vodcancelitem) throws Exception {
		db1SyncDao.updateVodCancelTbl(vodcancelitem);
	}

	public void insertVodCancelTbl(VodBuyCancelVO vodcancelitem) throws Exception {
		db1SyncDao.insertVodCancelTbl(vodcancelitem);
	}
}
