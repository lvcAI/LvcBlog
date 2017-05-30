package party.pjc.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import party.pjc.blog.dao.PostDao;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.model.Post;
import party.pjc.blog.model.Post_Categories;
import party.pjc.blog.model.Post_Tags;
import party.pjc.blog.service.PostService;

@Service("postService")
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;
	
	@Override
	public List<Post> findAllPost(int id) {
		// TODO Auto-generated method stub
		return this.postDao.findAllPost(id) ;
	}

	@Override
	public Post findPostById(int id) {
		// TODO Auto-generated method stub
		return this.postDao.findPostById(id);
	}

	@Override
	public int updatePostByRate(Post post) {
		// TODO Auto-generated method stub
		return postDao.updatePostByRate(post);
	}

	@Override
	public List<Post> findPostLimit(PageBean pageBean) {
		// TODO Auto-generated method stub
		return this.postDao.findPostLimit(pageBean);
	}

	@Override
	public int getPostCount() {
		// TODO Auto-generated method stub
		return this.postDao.getPostCount();
	}

	@Override
	public List<Post> selectPostsAndTags(PageBean pageBean) {
		// TODO Auto-generated method stub
		return this.postDao.selectPostsAndTags(pageBean);
	}

	@Override
	public int insertPost(Post post) {
		// TODO Auto-generated method stub
		return this.postDao.insertPost(post);
	}

	@Override
	public Post findPostByTitle(String title) {
		// TODO Auto-generated method stub
		return this.postDao.findPostByTitle(title);
	}

	@Override
	public int insertPostAndTag(Post_Tags post_tag) {
		// TODO Auto-generated method stub
		return this.postDao.insertPostAndTag(post_tag);
	}

	@Override
	public int insertPostAndCate(Post_Categories post_cate) {
		// TODO Auto-generated method stub
		return this.postDao.insertPostAndCate(post_cate);
	}

	@Override
	public int updatePost(Post post) {
		// TODO Auto-generated method stub
		return this.postDao.updatePost(post);
	}

	@Override
	public List<Post> findUpAndDown(Integer id) {
		List<Post> postlist = new ArrayList<Post>();
		Post up=postDao.findUpPost(id);
		if(up==null){
			postlist.add(new Post(-1,""));
		}else{
			postlist.add(new Post(up.getId(),up.getTitle()));
		}
		Post down=postDao.findDownPost(id);
		if(down==null){
			postlist.add(new Post(-1,""));
		}else{
			postlist.add(new Post(down.getId(),down.getTitle()));
		}		
		return postlist;
	}

	
}
