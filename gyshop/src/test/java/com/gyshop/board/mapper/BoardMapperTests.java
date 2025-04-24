package com.gyshop.board.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gyshop.board.vo.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.list().forEach(board -> log.info(board));
	}
	
	//@Test
	public void testWrite() {
		BoardVO vo = new BoardVO();
		vo.setTitle("Spring으로 구현한 글");
		vo.setContent("spring5 사용");
		vo.setWriter("이현진");
		vo.setPw("11111");
		
		mapper.write(vo);
		
		log.info(vo);
	}
	
	//@Test
	public void testView() {
		BoardVO vo = mapper.view(223L);
		
		log.info(vo);
	}
	
	//@Test
	public void testDelete() {
		BoardVO vo = new BoardVO();
		vo.setNo(24L);
		vo.setPw("1111");
		
		Integer result = mapper.delete(vo);
		
		log.info(result);
	}
}
