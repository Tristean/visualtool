package com.visual.enums;

public enum StateEnum {
	SUCCESS(1,"�����ѷ���"),
	FAILED(-1,"����ʧ��");
	
	private int state;
	private String stateInfo;
	
	
	private StateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	
	
}
