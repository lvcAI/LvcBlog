package party.pjc.blog.controller;


import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import party.pjc.blog.model.UpImgResult;
import party.pjc.blog.model.vo.Result;
import party.pjc.blog.util.ResponseUtil;

@Controller
public class UploadController {
	
	@RequestMapping(value="/uploadfile",method=RequestMethod.POST)
	public String upload(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "editormd-image-file", required = false) MultipartFile attach){
		String rootPath = request.getSession().getServletContext().getRealPath("/resources/upload/");
		response.setHeader( "Content-Type" , "text/html" );
		ModelAndView mv = new ModelAndView();
		UpImgResult result = new UpImgResult();
		try {
			File filePath=new File(rootPath);		
			/**
			 * 文件路径不存在则需要创建文件路径
			 */
			if(!filePath.exists()){
				filePath.mkdirs();
			}
		
			//最终文件名
	        File realFile=new File(rootPath + File.separator + UUID.randomUUID().toString() + ".jpg");
	        FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);
	        System.out.println(realFile);
			
	       // mv.addObject("success", 1);
	        result.setSuccess(1);
		//	mv.addObject("message", "上传成功");
	        result.setMessage("上传成功");
			result.setUrl(realFile.getName());

			//mv.addObject("fileName", realFile.getName());
		} catch (Exception e) {
			result.setSuccess(0);
		//	mv.addObject("success", 0);
		//	mv.addObject("message", "上传失败，异常信息：" + e.getMessage());
			 result.setMessage( "上传失败，异常信息：" + e.getMessage());
		}
		System.out.println("UploadController：图片上传....");
		
		String gsonString = new Gson().toJson(result);  
		try {
			ResponseUtil.write(gsonString,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 七牛上传令牌获取
	 * @return
	 * @throws JblogException 
	 */
	
	@RequestMapping(value="/getQiniuToken",method=RequestMethod.POST)
	public String qiniu( HttpServletResponse response) {
		Result result1 = new Result();
		
	   Auth auth = Auth.create("u0Tk_hKZXbQHpSNxKei7R-XTnd3nBsqaFh9FFDnJ","CagYfRYJtK6X8SoSJ7QqzwNSWmQkDfPRNEIPKxaQ");
		String token = auth.uploadToken(
			"blogimg",	//空间名称
			null,			//key，最终资源名称，一般为空，让服务器自己生成
			3600,			//3600秒，上传时限
			new StringMap()	//其他上传策略
				.put("saveKey", UUID.randomUUID().toString() + "$(ext)")
		);
		System.out.println(token);
		result1.setResultCode(Result.SUCCESS);
		result1.setMessage("上传成功!");
		result1.setData( token);
		String result = new Gson().toJson(result1);
		try {
			ResponseUtil.write(result, response);
			System.out.println("已经返回了数据。。。。");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	    
	}
}
