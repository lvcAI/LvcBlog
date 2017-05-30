package party.pjc.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import party.pjc.blog.model.Comment;
import party.pjc.blog.model.vo.EmailResult;
import party.pjc.blog.service.CommentService;
import party.pjc.blog.service.PostService;
import party.pjc.blog.util.EmailUtils;
import party.pjc.blog.util.ResponseUtil;

@Controller
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(HttpServletRequest request,HttpServletResponse response) throws Exception{
	
	String name=request.getParameter("name");
	String email =request.getParameter("email") != null?request.getParameter("email"):null;
	String context =request.getParameter("context");
	String state = request.getParameter("state");
	Comment comment = new Comment(context,name,email,Integer.parseInt(state));
	System.out.println(comment);
	int result = commentService.insertComment(comment);
	EmailResult emailResult =null;
	//发送留言或评论信息
	if(Integer.parseInt(state)==0){
		emailResult = new EmailResult("328097822@qq.com", "您有一条新的留言",comment.getName()+":"+comment.getContext());
	}else{
		EmailResult emailResult1 = new EmailResult("328097822@qq.com", "您有一条新的评论",comment.getName()+":"+comment.getContext());
		EmailUtils.sendEmail(emailResult1);
		emailResult = new EmailResult(email== null?"328097822@qq.com":email, "来自iLvc.me 的提示","感谢您的评论，我将通过此邮箱与你联系。谢谢");
	}
	EmailUtils.sendEmail(emailResult);
	if(result>0){
		ResponseUtil.write(result, response);
	}else{
		ResponseUtil.write(result, response);
	}
	System.out.println(name);
	
	return null;
	}
	
	
	
	
}
