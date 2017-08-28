package party.pjc.blog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;

import party.pjc.blog.model.Link;
import party.pjc.blog.model.PageBean;
/**
 * 
 * @author lvc
 *
 *	链接拥有的功能  查看所有链接 更新链接状态 删除链接
 *
 *	findAllLink(Link link ) 
 *	
 *
 */
public interface LinkDao {
	

    int insertLink(Link link);

    int updateLinkByIdOrName(Link link);
   
    List<Link> findAllLink(HashMap map ); 
    
    int updateLinkStateOrordernum(Link link);
    
    Link findLink(Link link);
    
    int findLinkCount(Link link);
    List<Link> findAllLinkByType(@PathParam("state") int state);
}