package com.visual.web;


import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.visual.dto.Operation;
import com.visual.entity.ConfigBean;
import com.visual.service.ExchangeService;
import com.visual.service.imp.BaseExChangeServiceImp;
import com.visual.util.JsonUtil;

@Controller
@RequestMapping("/visual")
public class VisualController {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	private ExchangeService es=new BaseExChangeServiceImp();
	
	@RequestMapping(value="/execution",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public Operation execute(@RequestBody String  config){
		//Operation op=es.execute(config, file);
		ConfigBean con=JsonUtil.parse(config);
		System.out.println(config);
		System.out.println(con);
		return null;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String detail() {
		return "Main";
	}
}
