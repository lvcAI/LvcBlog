package party.pjc.blog.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import party.pjc.blog.model.Notice;
import party.pjc.blog.model.PageBean;

public interface NoticeService {

	
	int delete(Integer id);

	int update(Notice notice);
	Notice findNoticeById(Integer id);
	
	int size(Integer type);
	
    int insert(Notice notice);
    // 方法分析
    // notice 
    List<Notice> findNotices();
    
    List<Notice> findLimitNotice( Notice notice, PageBean page);
}
