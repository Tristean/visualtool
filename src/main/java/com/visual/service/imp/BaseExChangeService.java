package com.visual.service.imp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.visual.entity.ConfigBean;
import com.visual.service.ExchangeService;
import com.visual.service.abs.AbstractExChangeService;

public class BaseExChangeService extends AbstractExChangeService implements ExchangeService {
	
	
	@Override
	public void makeXml(ConfigBean config,File file) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document document=db.newDocument();
			document.setXmlStandalone(true);
			
			HashMap<String,String[]>requiredValue=config.getRequiredValue();
			HashMap<String,String[]>optionalValue=config.getOptionalValue();
			
			//创建根节点
			Element root=createRoot(document);
			//根节点设置子节点并赋值
			SetMustProperty(root,config,document);
			SetRequiredProperty(root,config,document,requiredValue);
			SetDoNotModify(root,document);
			//设置可选条件			
			if(config.getOptionalmap()!=null) {
				setOptionalProperty(root,config,document,optionalValue);
			}
			
			document.appendChild(root);
			TransformerFactory tff=TransformerFactory.newInstance();
	        Transformer tf=tff.newTransformer();
	        tf.setOutputProperty(OutputKeys.INDENT, "yes");
	        tf.transform(new DOMSource(document), new StreamResult(file));
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	
	protected void SetDoNotModify(Element root, Document document) {
		// TODO Auto-generated method stub
		Element property=document.createElement("property");
		property.setAttribute("name", "template_path");
		property.setAttribute("value","#{template_dir}/drm/drm_monitor_template.xml");
		
		root.appendChild(property);
	}


	private void setOptionalProperty(Element root, ConfigBean config, Document document,HashMap<String,String[]>optionalValue) {
		// TODO Auto-generated method stub
		
		Element optionSet=document.createElement("optional-condition-set");
		
		HashMap<String,String>optional=config.getOptionalmap();
		
		for(Map.Entry<String,String> entry:optional.entrySet()) {
			
			String[]values=optionalValue.get(entry.getKey());
			
			Element requiredCondition=document.createElement("optional-condition");
			requiredCondition.setAttribute("name", entry.getKey());
			if(entry.getValue()!=null) {
				requiredCondition.setAttribute("type",entry.getValue());
			}
			
			String value="";
			for(int i=0;i<values.length;i++) {
				if(i==values.length-1||i==1) {
					value+=values[i];
					break;
				}
				value+=values[i]+",";
			}
			requiredCondition.setTextContent(value);
			
			optionSet.appendChild(requiredCondition);
		}
		
		root.appendChild(optionSet);
	}


	//设置要求条件	
	protected void SetRequiredProperty(Element root, ConfigBean config, Document document,HashMap<String,String[]>requiredValue) {
		// TODO Auto-generated method stub
		HashMap<String,String>required=config.getRequiredmap();
		
		for(Map.Entry<String,String> entry:required.entrySet()) {
			
			String[]values=requiredValue.get(entry.getKey());
			
			Element requiredCondition=document.createElement("required-condition");
			requiredCondition.setAttribute("name", entry.getKey());
			if(entry.getValue()!=null) {
				requiredCondition.setAttribute("type",entry.getValue());
			}
			
			String value="";
			for(int i=0;i<values.length;i++) {
				if(i==values.length-1||i==1) {
					value+=values[i];
					break;
				}
				value+=values[i]+",";
			}
			requiredCondition.setTextContent(value);
			
			root.appendChild(requiredCondition);
		}
		
		System.out.println("success");
	}



	//根节点添加子节点
	protected void SetMustProperty(Element root,ConfigBean config,Document document) {
		// TODO Auto-generated method stub
		//设置邮件主题标签
		Element mail_subject=document.createElement("mail-subject"),
				mail_to=document.createElement("mail-to"),
				mail_cc=document.createElement("mail-cc");
		
		mail_subject.setTextContent(config.getMail_subject());
		
		//设置邮件收件人
		String to="";
		for(int i=0;i<config.getMailTo().length;i++) {
			if(i==config.getMailTo().length-1||config.getMailTo().length==1) {
				to+=config.getMailTo()[i];
				break;
			}
			to+=config.getMailTo()[i]+",";
		}
		mail_to.setTextContent(to);
		
		
		String cc="";
		//设置抄送人
		for(int i=0;i<config.getCc().length;i++) {
			if(i==config.getCc().length-1||config.getCc().length==1) {
				cc+=config.getCc()[i];
				break;
			}
			cc+=config.getCc()[i]+",";
		}
		System.out.println(cc);
		mail_cc.setTextContent(cc);
		root.appendChild(mail_subject);
		root.appendChild(mail_to);
		root.appendChild(mail_cc);
		
	}


	
	@Override
	public void sendCommand(String command) {
		// TODO Auto-generated method stub
		try {
			Process pro=Runtime.getRuntime().exec(new String[] {"java","-jar",
					"/home/tv_qos/itoolbox/iToolBoxPlugin.jar",command,"/home/tv_qos/zz/tempFile.xml"});
			int waitNumber=pro.waitFor();
			if(waitNumber==0) {
				System.out.println("success");
			}
			else {
				System.out.println("failed");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean deleteXml() {
		// TODO Auto-generated method stub
		return false;
	}

}
