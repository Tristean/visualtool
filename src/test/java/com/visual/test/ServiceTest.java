package com.visual.test;

import java.io.File;
import java.util.HashMap;

import com.visual.entity.ConfigBean;
import com.visual.service.ExchangeService;
import com.visual.service.imp.BaseExChangeServiceImp;

public class ServiceTest {
	public static void main(String[]args) throws Exception {
		ExchangeService es=new BaseExChangeServiceImp();
		
		File tempFile=new File("D:\\test\\tempFile.xml");
		ConfigBean config=new ConfigBean();
		String[]cc= {"zhouzhou_sx@qiyi","tt@qiyi.com","sasa"};
		config.setCc(cc);
		String[]mail= {"zhouzhou_sx@qiyi"};
		config.setMailTo(mail);
		
		HashMap<String,String>required=new HashMap<String,String>();
		HashMap<String,String[]>requiredValue=new HashMap<String,String[]>();
		String[]value= {"1998-0-1"};
		
		HashMap<String,String>option=new HashMap<String,String>();
		HashMap<String,String[]>optionalValue=new HashMap<String,String[]>();
		String []ovalue= {"2011183"};
		
		required.put("date", "date");
		requiredValue.put("date", value);
		
		option.put("channel", null);
		optionalValue.put("channel", ovalue);
		
		config.setRequiredmap(required);
		config.setRequiredValue(requiredValue);
		
		config.setOptionalmap(option);
		config.setOptionalValue(optionalValue);
		
		es.makeXml(config, tempFile);
	}
}
