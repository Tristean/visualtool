package com.visual.test;

import com.visual.service.imp.BaseExChangeServiceImp;

public class CommandTest {
	public static void main(String[]args) throws Exception {
		BaseExChangeServiceImp bes=new BaseExChangeServiceImp();
		bes.sendCommand("qfs");
	}
}
