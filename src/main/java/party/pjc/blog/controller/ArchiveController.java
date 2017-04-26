package party.pjc.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import party.pjc.blog.model.Tags;
import party.pjc.blog.service.TagsService;

@Controller

public class ArchiveController {

	@Autowired
	private TagsService tagsService;

	@RequestMapping(value="/archive",method=RequestMethod.GET)
	public String allTag(HttpServletRequest requset){
		
				return "/archive/archive";
			}
			
				
		
}
	
