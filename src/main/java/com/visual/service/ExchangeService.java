package com.visual.service;

import java.io.File;

import com.visual.entity.ConfigBean;

public interface ExchangeService {
	
	public void makeXml(ConfigBean config,File file) ;
	
	public void sendCommand(String command);
	
	public boolean deleteXml();
	
}
