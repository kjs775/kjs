package com.example.demo.api;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BoardDto;
import com.example.demo.mapper.BoardMapper;

@RestController
public class HelloController {
	
	private static BoardMapper mapper;
	private static SqlSessionFactory factory = null; 
	static {
		String file = "com/example/demo/config/config.xml";
		try {
			InputStream is = Resources.getResourceAsStream(file);
			factory = new SqlSessionFactoryBuilder().build(is);
			
			SqlSession session = factory.openSession();
			
			mapper = session.getMapper(BoardMapper.class);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/board/list")
	public List<BoardDto> list(){
		SqlSession session = factory.openSession();
		mapper = session.getMapper(BoardMapper.class);
		
		List<BoardDto> list = mapper.findAll();
		return list;
	}
	
	@RequestMapping(value="/board/get", method=RequestMethod.GET)
	public List<BoardDto> listByIdx(@RequestParam(name="where", required=false) String where){
		if( where == null) { return list();}
		SqlSession session = factory.openSession();
		mapper = session.getMapper(BoardMapper.class);
		List<BoardDto> list = null;
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		String[] str = where.split(",");
		List<String> qs = new ArrayList<String>();
		for(int i=0;i<str.length;i++) {
			qs.add(str[i]);
		}
		map.put("list",qs);
		list = mapper.findByIdx(map);
		return list;
		
	}
	
	@RequestMapping(method= RequestMethod.GET, value = "/board/add")
	public String add(@RequestParam(name="title", required=true) String title, @RequestParam(name="content",required=true) String content) {
		Random r = new Random();
		int num = r.nextInt();
		BoardDto b = new BoardDto(num,title, content);
		
		try{		
			mapper.addBoard(b);
			mapper.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "{\"result\": \"OK\"}";
	}	
}
