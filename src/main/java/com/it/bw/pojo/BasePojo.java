package com.it.bw.pojo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.it.bw.util.DateFormatUtil;

public class BasePojo {
	private Date createtime;
	private Date updatetime;
	@JsonSerialize(using=DateFormatUtil.class)
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@JsonSerialize(using=DateFormatUtil.class)
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
}
