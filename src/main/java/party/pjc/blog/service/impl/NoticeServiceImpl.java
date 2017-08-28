package party.pjc.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import party.pjc.blog.dao.NoticeDao;
import party.pjc.blog.model.Notice;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public int insert(Notice notice) {
		return noticeDao.insert(notice);
	}

	@Override
	public List<Notice> findNotices() {
		return noticeDao.findNotices();
	}

	@Override
	public List<Notice> findLimitNotice(Notice notice, PageBean page) {
		return noticeDao.findLimitNotice(notice, page);
	}

	@Override
	public int size(Integer type) {
		return noticeDao.size(type);
	}

	@Override
	public int delete(Integer id) {
		return noticeDao.delete(id);
	}

	@Override
	public int update(Notice notice) {
		return noticeDao.update(notice);
	}

	@Override
	public Notice findNoticeById(Integer id) {
		return noticeDao.findNoticeById(id);
	}

	
}
