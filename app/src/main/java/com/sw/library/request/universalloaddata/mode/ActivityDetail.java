package com.sw.library.request.universalloaddata.mode;

import java.io.Serializable;
import java.util.ArrayList;

public class ActivityDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String endTime;
	public int iscol;
	public String isfree;
	public String pic;
	public String needsigup;
	public String createtime;
	public int id;
	public String title;
	public String actway;
	public String actcon;
	public int issignup;
	public String subtitle;
	public String begdate;
	public String actaward;
	public String enddate;
	public String actsite;
	public String begtime;
	public ArrayList<Poi> poilist;
	
	
	
	public ArrayList<Poi> getPoilist() {
		return poilist;
	}
	public void setPoilist(ArrayList<Poi> poilist) {
		this.poilist = poilist;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getIscol() {
		return iscol;
	}
	public void setIscol(int iscol) {
		this.iscol = iscol;
	}
	public String getIsfree() {
		return isfree;
	}
	public void setIsfree(String isfree) {
		this.isfree = isfree;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getNeedsigup() {
		return needsigup;
	}
	public void setNeedsigup(String needsigup) {
		this.needsigup = needsigup;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getActway() {
		return actway;
	}
	public void setActway(String actway) {
		this.actway = actway;
	}
	public String getActcon() {
		return actcon;
	}
	public void setActcon(String actcon) {
		this.actcon = actcon;
	}
	public int getIssignup() {
		return issignup;
	}
	public void setIssignup(int issignup) {
		this.issignup = issignup;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getBegdate() {
		return begdate;
	}
	public void setBegdate(String begdate) {
		this.begdate = begdate;
	}
	public String getActaward() {
		return actaward;
	}
	public void setActaward(String actaward) {
		this.actaward = actaward;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getActsite() {
		return actsite;
	}
	public void setActsite(String actsite) {
		this.actsite = actsite;
	}
	public String getBegtime() {
		return begtime;
	}
	public void setBegtime(String begtime) {
		this.begtime = begtime;
	}
	
	@Override
	public String toString() {
		return title + "," + actway;
	}
	
}
