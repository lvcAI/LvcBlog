package party.pjc.blog.service;

import java.util.List;

import party.pjc.blog.model.Tags;

public interface TagsService {

public List<Tags> findAllTag();
	
	public int insertTag(Tags tag);

	public int updateTag(int id);
	
	public int deleteTag(int id);
	//����tagname ���������е�post
	public Tags findPostByTag(String tagName);
	
	public Tags findTagsByName(String tagName);
	
	public int findPostCountByTags(Tags tag);
}
