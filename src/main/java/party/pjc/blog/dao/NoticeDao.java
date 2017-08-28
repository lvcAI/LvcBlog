package party.pjc.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import party.pjc.blog.model.Notice;
import party.pjc.blog.model.PageBean;

public interface NoticeDao {
    
    int delete(@Param("id") Integer id);
    int insert(Notice notice);
    int update(Notice notice);
    Notice findNoticeById(@Param("id")Integer id);
    List<Notice> findNotices();
    List<Notice> findLimitNotice(@Param("notice") Notice notice,@Param("page") PageBean page);
    int size(@Param("type")Integer type);
    
}