package party.pjc.blog.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import party.pjc.blog.model.Notice;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.dao.NoticeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"classpath:applicationContext.xml",
		"classpath:spring-mvc.xml"})
public class NoticeDaoTest {

	@Autowired
	private NoticeDao noticeDao;
	
	@Test
	public void testFindLimitNotice(){
		
		Notice notice = new Notice();
		notice.setType((Integer) null);
		List<Notice> notices = noticeDao.findLimitNotice(notice,new PageBean(1, 3));
		for (Notice notice2 : notices) {
			System.out.println(notice2);
			
		}
	}
	
	@Test
	public void testSize(){
		
		//int size =noticeDao.size(0);
		List<Notice> notices =noticeDao.findNotices();
		for (Notice notice2 : notices) {
			System.out.println(notice2);
			
		}
		
		
	}
	@Test
	public void testInsert(){
		Notice notice = new Notice();
		notice.setTitle("不忘初心,方得始终。");
		notice.setBookname("佛家箴言");
		notice.setType(0);
		
		System.out.println(noticeDao.insert(notice));
	}
	
	@Test
	public void testFindNoticeById(){
		
		System.out.println(noticeDao.findNoticeById(9));
	}
	
	@Test
	public void testDelete(){
		
		
		System.out.println(noticeDao.delete(9));
	}
	
	
}
