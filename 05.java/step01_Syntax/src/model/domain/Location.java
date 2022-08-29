package model.domain;

public class Location {

	private String ContentName;
	private String BusanLocation;
	private int OperateTime;
	
	public Location (String BusanLocation, String ContentName, int OperateTime) {
		
		this.BusanLocation = BusanLocation;
		this.ContentName = ContentName;
		this.OperateTime = OperateTime;
		
	}
	
	public String getContentName() {
		
		return ContentName;
	}
	
		
public int getOperateTime() {
		
		return OperateTime;
	}
	
	
	
}
