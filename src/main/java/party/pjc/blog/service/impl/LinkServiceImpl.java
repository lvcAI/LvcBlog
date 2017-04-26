package party.pjc.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import party.pjc.blog.dao.LinkDao;
import party.pjc.blog.model.Link;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.service.LinkService;

@Service
public class LinkServiceImpl implements LinkService{
	
	@Autowired
	private LinkDao linkDao;
	
	@Override
	public int insertLink(Link link) {
		// TODO Auto-generated method stub
		return this.linkDao.insertLink(link);
	}

	@Override
	public int updateLinkByIdOrName(Link link) {
		// TODO Auto-generated method stub
		return this.linkDao.updateLinkByIdOrName(link);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Link> findAllLink(Link link, PageBean pageBean) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("link", link);
		map.put("pageBean", pageBean);
		return this.linkDao.findAllLink(map);
	}

	@Override
	public int updateLinkStateOrOrderNum(Link link) {
		// TODO Auto-generated method stub
		return this.linkDao.updateLinkByIdOrName(link);
	}

	@Override
	public Link findLink(Link link) {
		// TODO Auto-generated method stub
		return this.linkDao.findLink(link);
	}

	@Override
	public int findLinkCount(Link link) {
		// TODO Auto-generated method stub
		return this.linkDao.findLinkCount(link);
	}

}
