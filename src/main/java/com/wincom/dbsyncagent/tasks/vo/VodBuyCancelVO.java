package com.wincom.dbsyncagent.tasks.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VodBuyCancelVO {

	String pvs_sbc_cont_no = "";
	String pvs_mac_addr = "";
	String buy_date = "";

	String udr_grp_no = "";
	String udr_grp_seq_no = "";
	String udr_grp_cnt = "";

	String cnts_cd = "";
	String rate_typ_cd = "";
	String pvs_cancel_date = "";
	String process_flag = "";

	String error_msg = "";
	

	
}
