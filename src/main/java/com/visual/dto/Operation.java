package com.visual.dto;

import com.visual.enums.StateEnum;

public class Operation {
	private int state;
	private String stateInfo;
	
	
	public Operation(StateEnum stateEnum) {
		this.state=stateEnum.getState();
		this.stateInfo=stateEnum.getStateInfo();
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


	@Override
	public String toString() {
		return "Operation [state=" + state + ", stateInfo=" + stateInfo + "]";
	}
	
	
	
}
