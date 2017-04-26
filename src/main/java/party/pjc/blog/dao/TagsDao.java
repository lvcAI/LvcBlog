package party.pjc.blog.dao;

import java.util.List;

import party.pjc.blog.model.Tags;

public interface TagsDao {

	public List<Tags> findAllTag();
	
	public int insertTag(Tags tag);

	public int updateTag(int id);
	
	public int deleteTag(int id);
	public Tags findTagsByName(String tagName);
	public Tags findPostByTag(String tagName);
	public int findPostCountByTags(Tags tag);
}
