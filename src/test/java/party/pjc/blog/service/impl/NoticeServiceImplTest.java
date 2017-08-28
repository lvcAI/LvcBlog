package party.pjc.blog.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import party.pjc.blog.model.Notice;
import party.pjc.blog.service.NoticeService;
import party.pjc.blog.util.NoticeConvertUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"classpath:applicationContext.xml",
		"classpath:spring-mvc.xml"})
public class NoticeServiceImplTest {

	@Autowired 
	private NoticeService noticeService;
	
	@Test 
	public void test(){
		
		List<Notice> notices = NoticeConvertUtil.noticeConver(3, noticeService);
		for(Notice t: notices){
			System.out.println(t);
		}
	}
}
