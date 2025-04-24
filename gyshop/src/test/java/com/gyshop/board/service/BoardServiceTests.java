package com.gyshop.board.service;

import static org.junit.Assert.assertNotNull;

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
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testWrite() {
		BoardVO vo = new BoardVO();
		vo.setTitle("spring service");
		vo.setContent("spring service 구현");
		vo.setWriter("STS4");
		vo.setPw("1111");
		
		service.write(vo);
		
		log.info("생성된 게시물의 번호 : " + vo.getNo());
	}
	
}
