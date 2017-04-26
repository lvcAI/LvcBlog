package party.pjc.blog.dao;

import java.util.List;

import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Post;
import party.pjc.blog.model.Post_Categories;
import party.pjc.blog.model.Post_Tags;

public interface PostDao {

	public Post findPostById(int id);
	public Post findPostByTitle(String title);
	public List<Post> findAllPost();
	
	public int insertPost(Post post);
	public int insertPostAndTag(Post_Tags post_tag);
	public int insertPostAndCate(Post_Categories post_cate);
	public int updatePost(Post post);
	public int deletePost(int id);
	public int updatePostByRate(Post post);
	
	public List<Post> findPostLimit(PageBean pageBean);
	
	public int getPostCount();
	
	
	public List<Post> selectPostsAndTags(PageBean pageBean);
	
	
	public Post findUpPost(Integer id);
	public Post findDownPost(Integer id);
	
}
