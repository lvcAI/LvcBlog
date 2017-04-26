package party.pjc.blog.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import party.pjc.blog.dao.CommentDao;
import party.pjc.blog.model.Comment;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public int insertComment(Comment comment) {
		// TODO Auto-generated method stub
		return this.commentDao.insertComment(comment);
	}

	@Override
	public int updateComment(Comment comment) {
		// TODO Auto-generated method stub
		return this.commentDao.updateComment(comment);
	}

	@Override
	public int countComment(Comment comment) {
		// TODO Auto-generated method stub
		return this.commentDao.countComment(comment);
	}

	@Override
	public List<Comment> listComment(Comment comment, PageBean pageBean) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("comment", comment);
		map.put("pageBean", pageBean);
		return this.commentDao.listComment(map);
	}

	
}
