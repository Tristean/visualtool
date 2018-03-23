package com.visual.test;

import com.visual.service.imp.BaseExChangeService;

public class CommandTest {
	public static void main(String[]args) {
		BaseExChangeService bes=new BaseExChangeService();
		bes.sendCommand("qfs");
	}
}
