package com.ex2.user;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
public class UserController {
    
	
	
	//무슨 컨트롤러 든지 "Controller" 타고 가게 한다.
	//IP주소랑 이런거는 이렇게 알면 안되나 ...
	private static final Logger LOGGER = LoggerFactory.getLogger("Controller");
	private static final Logger LOGGER2 = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserMapper userMapper;
    HttpServletRequest req;
    String ip;
    UserDTO[] dto;
    static{
    	
    }
    
    @RequestMapping(path = "/")
    public String hello() {
    	dto = userMapper.findAll();
    	req= ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
    	ip = req.getRemoteAddr();
    	MDC.put("ip", ip);
        MDC.put("id", Integer.toString(dto[2].getId()));
        
        LOGGER.trace("SHOW:trace");
    	LOGGER.debug("SHOW:debug");
    	LOGGER.info("sample", "hiroo");
    	LOGGER.info("SHOW:info");
    	LOGGER.warn("SHOW:warn");
    	LOGGER.error("SHOW:error");
    	LOGGER.error("sample");
    	LOGGER.error("SHOW:warn");
        
//    	LOGGER2.trace("SHOW:trace");
//    	LOGGER2.debug("SHOW:debug");
//    	LOGGER2.info("SHOW:info");
//    	LOGGER2.warn("SHOW:warn");
//    	LOGGER2.error("SHOW:error");
//    	LOGGER2.error("sample");
//    	LOGGER2.error("SHOW:warn");
        return "hello world";
    }
    
    @RequestMapping(path = "/test")
    public int show(Model model) throws UnknownHostException {
        
        
    	dto = userMapper.findAll();
        MDC.put("ip", ip);
        MDC.put("id", Integer.toString(dto[2].getId()));
        
        
        LOGGER2.info("IP={}",ip);
        LOGGER.info("TEST:ID ={}",dto[2].getId());
        LOGGER2.info("TEST:ID ={}",dto[2].getId());
        /*
         * 여기에다가 다른내용이 있으면 기입 하는 것이다.
         */ 
        LOGGER.info("TEST:이놈은 거래를 했어요");
        LOGGER.info("TEST:단문에시지 하나를 날렸어요");
        LOGGER.info("TEST:참잘했지유");
        LOGGER2.info("TEST:이놈은 거래를 했어요");
        LOGGER2.info("TEST:단문에시지 하나를 날렸어요");
        LOGGER2.info("TEST:참잘했지유");
        /*
         * 이런식으로 하나하나가 무엇을 했는지 로그에 남길 수 있지 않을까?
         */ 
        //LOGGER.info(Integer.toString(dto[2].getId()));
        return dto[2].getId();
    }
    
}


