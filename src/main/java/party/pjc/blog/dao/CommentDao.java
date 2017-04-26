package party.pjc.blog.dao;

import java.util.HashMap;
import java.util.List;

import party.pjc.blog.model.Comment;
import party.pjc.blog.model.PageBean;

public interface CommentDao {

    /**
     * 插入一条评论
     * @param comment
     * @return int 
     */
    int insertComment(Comment comment);
    
    /**
     * 回收一条评论，不做删除处理，改变其state为 2
     * @param comment
     * @return
     */
    int updateComment(Comment comment);

    /**
     * 统计 comment 总数，可按 state，获取不同类型的comment
     * @param comment 查询参数，一般是new comment 传入相应的参数
     * @return int 总数
     */
    int countComment(Comment comment);
    
    /**
     * 获取评论 的list集合
     * @param comment 一般是new comment 传入相应的参数
     * @param pageBean 一般是new pageBean 传入相应的参数
     * @return comment 集合
     */
    List<Comment> listComment(HashMap<String, Object> map);
    
    
}