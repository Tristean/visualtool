package com.visual.service.abs;

import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.visual.entity.ConfigBean;

public abstract class AbstractExChangeService {
	protected abstract void SetMustProperty(Element root,ConfigBean config,Document document);
	
	protected abstract void SetRequiredProperty(Element root,ConfigBean config,Document document,HashMap<String,String[]>requiredValue);
	
	protected abstract void SetDoNotModify(Element root,Document document);
	
	//创建根节点
	protected Element createRoot(Document document) {
			// TODO Auto-generated method stub
			Element root=document.createElement("userConfig");
			
			root.setAttribute("xmlns", "http://schemas.itoolbox.com/qos/userconfig");
			root.setAttribute("xmlns:xi", "http://www.w3.org/2001/XInclude");
			
			return root;
	}

}
