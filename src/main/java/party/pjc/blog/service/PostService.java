package party.pjc.blog.service;

import java.util.List;

import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Post;
import party.pjc.blog.model.Post_Categories;
import party.pjc.blog.model.Post_Tags;

public interface PostService {

	public List<Post> findAllPost();
	
	public Post findPostById(int id);
	public int updatePost(Post post);
	public int updatePostByRate(Post post);
	
	public List<Post> findPostLimit(PageBean pageBean);
	
	public int getPostCount();
	
	public List<Post> selectPostsAndTags(PageBean pageBean);
	
	public int insertPost(Post post);
	public int insertPostAndTag(Post_Tags post_tag);
	public int insertPostAndCate(Post_Categories post_cate);
	public Post findPostByTitle(String title);
	public List<Post> findUpAndDown(Integer id);

}
