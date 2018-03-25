package com.visual.entity;

import java.util.HashMap;

public class ConfigBean {
	
	//邮件主题
	private String mail_subject;
	//邮件发送人
	private String[]mailTo;
	//邮件抄送人
	private String[]cc;	
	//必要条件信息
	private HashMap<String,String>requiredmap=new HashMap<String,String>();
	private HashMap<String,String[]>requiredValue=new HashMap<String,String[]>();
	//可选条件信息	
	private HashMap<String,String>optionalmap=new HashMap<String,String>();
	private HashMap<String,String[]>optionalValue=new HashMap<String,String[]>();
	//命令参数
	private String command;
	
	
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public HashMap<String, String> getOptionalmap() {
		return optionalmap;
	}
	public void setOptionalmap(HashMap<String, String> optionalmap) {
		this.optionalmap = optionalmap;
	}
	public HashMap<String, String[]> getOptionalValue() {
		return optionalValue;
	}
	public void setOptionalValue(HashMap<String, String[]> optionalValue) {
		this.optionalValue = optionalValue;
	}
	public HashMap<String, String[]> getRequiredValue() {
		return requiredValue;
	}
	public void setRequiredValue(HashMap<String, String[]> requiredValue) {
		this.requiredValue = requiredValue;
	}
	
	public HashMap<String, String> getRequiredmap() {
		return requiredmap;
	}
	public void setRequiredmap(HashMap<String, String> requiredmap) {
		this.requiredmap = requiredmap;
	}
	
	public String getMail_subject() {
		return mail_subject;
	}
	public void setMail_subject(String mail_subject) {
		this.mail_subject = mail_subject;
	}
	public String[] getMailTo() {
		return mailTo;
	}
	public void setMailTo(String[] mailTo) {
		this.mailTo = mailTo;
	}
	
	public String[] getCc() {
		return cc;
	}
	public void setCc(String[] cc) {
		this.cc = cc;
	}
		
}
