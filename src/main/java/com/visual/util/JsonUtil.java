package com.visual.util;

import com.alibaba.fastjson.JSONObject;
import com.visual.entity.ConfigBean;

public class JsonUtil {
	
	public static ConfigBean parse(String config) {
		JSONObject json=(JSONObject) JSONObject.parse(config);
		ConfigBean con=new ConfigBean();
		con.setCommand(json.getString("command"));
		con.setMail_subject(json.getString("subject"));
		con.setMailTo(JsonUtil.parseArray(json.getString("to")));
		con.setCc(JsonUtil.parseArray(json.getString("cc")));
		return con;
	}
	
	public static String[]parseArray(String str){
		String[]strs=str.split(",");
		return strs;
	}
	
	
}
