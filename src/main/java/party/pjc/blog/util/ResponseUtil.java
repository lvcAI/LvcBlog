package party.pjc.blog.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;


public class ResponseUtil {

	public static void write(Object o,HttpServletResponse response)throws Exception{
		//response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");  
		PrintWriter out=response.getWriter();
		out.println(o.toString());
		out.flush();
		out.close();
	}
}
