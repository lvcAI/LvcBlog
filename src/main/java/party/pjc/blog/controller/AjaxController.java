package party.pjc.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.abel533.echarts.Option;
import com.google.gson.Gson;

import party.pjc.blog.model.Post;
import party.pjc.blog.service.ChartService;
import party.pjc.blog.service.PostService;
import party.pjc.blog.util.ResponseUtil;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired
	private PostService postService;
	@Autowired
	private ChartService chartService;
	
	@ResponseBody
	@RequestMapping("/postClick2")
	public ModelAndView echartPostclick(HttpServletResponse response){
		
		List<Post> posts = postService.findAllPost(1);
		String[] title = new String[posts.size()];
		int[] rate = new int[posts.size()];
		for(int i=0;i<posts.size();i++){
			title[i]=posts.get(i).getTitle();
			rate[i]=(int) posts.get(i).getRate();
		}
		Result result = new Result(title, rate);
		String data = new Gson().toJson(result);
		System.out.println(data);
		try {
			ResponseUtil.write(data, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/postClick")
	public ModelAndView echartPostclick2(HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		Option option = chartService.postClick();
		mav.addObject("option",option);
		try {
			ResponseUtil.write(option, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	class Result{
		
		String[] title = null ;
		int[] rate = null;
		public Result(String[] title, int[] rate) {
			super();
			this.title = title;
			this.rate = rate;
		}
		
		
	}
	
	
}