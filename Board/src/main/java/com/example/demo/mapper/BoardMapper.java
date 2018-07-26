package com.example.demo.mapper;


import java.util.List;
import java.util.Map;

import com.example.demo.dto.BoardDto;

public interface BoardMapper {
	public List<BoardDto> findAll();
	public List<BoardDto> findByIdx(Map<String, List<String>> map);
	public BoardDto findOneById(int idx);
	public List<BoardDto> findWithCondition(Map<String, Object> map);
	public void addBoard(BoardDto boardDto);
	public void modifyBoard(BoardDto boardDto);
	public void removeBoard(int idx);
	public void removeAll();
	public void updateViewCnt(int idx);
	public void updateTitle(BoardDto boardDto);
	public void commit();
}
