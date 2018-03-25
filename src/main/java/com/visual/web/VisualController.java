package com.visual.web;


import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visual.dto.Operation;
import com.visual.entity.ConfigBean;
import com.visual.service.ExchangeService;
import com.visual.service.imp.BaseExChangeServiceImp;

@Controller
@RequestMapping("/visual")
public class VisualController {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	private ExchangeService es=new BaseExChangeServiceImp();
	
	@RequestMapping(value="/execution" )
	public Operation execute(ConfigBean config,File file){
		es.
	} 
}
