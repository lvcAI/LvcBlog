package party.pjc.blog.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import party.pjc.blog.dao.NoticeDao;
import party.pjc.blog.model.Notice;
import party.pjc.blog.model.PageBean;
import party.pjc.blog.service.CategoriesService;
import party.pjc.blog.service.NoticeService;
import party.pjc.blog.service.PostService;
import party.pjc.blog.service.TagsService;
import party.pjc.blog.service.UserService;
import party.pjc.blog.sys.LvcBlogSystem;
import party.pjc.blog.util.PageUtil;
import party.pjc.blog.util.ResponseUtil;
import party.pjc.blog.util.StringUtil;

@Controller
@RequestMapping("/admin/notice")
public class NoticeAdminController {
	
	@Autowired
	private NoticeService noticeService;
	private LvcBlogSystem system;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView addNotice(){
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("mainPage", "notice/add.jsp");
		mav.setViewName("/admin");
		return mav;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveNotice(Notice notice,HttpServletResponse response,HttpServletRequest request){
		String updateId=request.getParameter("updateId");
		ModelAndView mav = new ModelAndView();
		// 更新notice
		if(StringUtil.isNotEmpty(updateId)){
			notice.setId(Integer.parseInt(updateId));
			noticeService.update(notice);
		//	mav.addObject("mainPage", "notice/list.jsp");
		}else{
			// 插入notice
			if(notice!=null){
				noticeService.insert(notice);
		//		mav.addObject("mainPage", "notice/list.jsp");
			
				//mav.addObject("list_notice",noticeService.findNotices());
				
			}else{
				//mav.addObject("mainPage", "notice/add.jsp");
				
			}
		}
		mav.setViewName("redirect:/admin/notice/list");
		return mav;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView listNotice(HttpServletRequest request){
		String basePath = request.getContextPath();
		ModelAndView mav = new ModelAndView();
		mav.addObject("navPage", PageUtil.getPagation(basePath+"/admin/notice/list", noticeService.size(null), 1, 10));
		mav.addObject("mainPage", "notice/list.jsp");
		mav.addObject("list_notice",noticeService.findLimitNotice(new Notice(),new PageBean(1, 10)));
		mav.setViewName("/admin");
		return mav;
	}
	
	@RequestMapping(value="/list/page/{page}",method=RequestMethod.GET)
	public ModelAndView listNoticePage(@PathVariable("page") String page,HttpServletRequest requset){
		int currentPage =0;
		if(page==null){
			currentPage=1;
		}else{
			currentPage = Integer.parseInt(page);
		}
		String basePath = requset.getContextPath();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list_notice",noticeService.findLimitNotice(new Notice(),new PageBean(currentPage, 10)));
		mav.addObject("navPage", PageUtil.getPagation(basePath+"/admin/notice/list", noticeService.size(null), currentPage, 10));
		mav.addObject("mainPage", "notice/list.jsp");
		mav.setViewName("/admin");
		return mav;
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public ModelAndView noticeUpdate(@PathVariable("id") int id,HttpServletRequest requset){
		ModelAndView mav = new ModelAndView();
		mav.addObject("update_notice", noticeService.findNoticeById(id));
		mav.addObject("mainPage", "notice/add.jsp");
		mav.setViewName("/admin");
		return mav;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	public String deletePost(@PathVariable("id") int id,HttpServletRequest requset,HttpServletResponse response){
		int result = noticeService.delete(id);
		try {
		if(result>0){
				ResponseUtil.write(1, response);
		}else{
			ResponseUtil.write(0, response);
		}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			system = new LvcBlogSystem();
			system.refreshSystem(requset);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
