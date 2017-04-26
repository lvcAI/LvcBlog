package party.pjc.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import party.pjc.blog.dao.TagsDao;
import party.pjc.blog.model.Tags;
import party.pjc.blog.service.TagsService;

@Service("tagsService")
public class TagsServiceImpl implements TagsService{

	@Autowired
	private TagsDao tagdDao;
	
	@Override
	public List<Tags> findAllTag() {
		return this.tagdDao.findAllTag();
	}

	@Override
	public int insertTag(Tags tag) {
		// TODO Auto-generated method stub
		return this.tagdDao.insertTag(tag);
	}

	@Override
	public int updateTag(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTag(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tags findPostByTag(String tagName) {
		// TODO Auto-generated method stub
		return this.tagdDao.findPostByTag(tagName);
	}

	@Override
	public Tags findTagsByName(String tagName) {
		// TODO Auto-generated method stub
		return this.tagdDao.findTagsByName(tagName);
	}

	@Override
	public int findPostCountByTags(Tags tag) {
		// TODO Auto-generated method stub
		return this.tagdDao.findPostCountByTags(tag);
	}
	
	
}
