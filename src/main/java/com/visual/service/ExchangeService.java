package com.visual.service;

import java.io.File;

import com.visual.dto.Operation;
import com.visual.entity.ConfigBean;

public interface ExchangeService {
	
	public void makeXml(ConfigBean config,File file) throws Exception ;
	
	public void sendCommand(String command) throws Exception;
	
	public boolean deleteXml();
	
	public Operation execute(ConfigBean config,File file);
	
}
