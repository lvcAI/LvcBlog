package party.pjc.blog.service;

import java.util.List;

import javax.websocket.server.PathParam;

import party.pjc.blog.model.Link;
import party.pjc.blog.model.PageBean;

public interface LinkService {
	 int insertLink(Link link);

	    int updateLinkByIdOrName(Link link);
	   
	    List<Link> findAllLink(Link link,PageBean pageBean ); 
	    
	    int updateLinkStateOrOrderNum(Link link);
	    
	    Link findLink(Link link);
	    
	    int findLinkCount(Link link);
	    List<Link> findAllLinkByType( int state);
}
