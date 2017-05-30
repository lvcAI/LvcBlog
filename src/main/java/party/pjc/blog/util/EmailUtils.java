package party.pjc.blog.util;



	import java.io.UnsupportedEncodingException;
import java.util.Properties;
	 
	import javax.mail.Authenticator;
	import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;

import party.pjc.blog.model.vo.EmailResult;
	
	
	public class EmailUtils {	 
		
		
		public static final  String from = "2442669938@qq.com";// 
		public  static final String pws ="kqxfyatvbbfddifh";//khgndvefptmdecga kqxfyatvbbfddifh
		
		
		public static void sendEmail(EmailResult email) throws Exception{
			
			 // 指定发送邮件的主机为 smtp.qq.com
		      String host = "smtp.qq.com";  //QQ 邮件服务器
		 
		      // 获取系统属性
		      Properties properties = System.getProperties();
		 
		      // 设置邮件服务器
		      
		      final String smtpPort = "465";
		      properties.setProperty("mail.smtp.host", host);
		      properties.put("mail.smtp.auth", "true");
		      properties.setProperty("mail.smtp.port", smtpPort);
		      properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		      properties.setProperty("mail.smtp.socketFactory.fallback", "false");
		      properties.setProperty("mail.smtp.socketFactory.port", smtpPort);
		      // 获取默认session对象
		      Session session = Session.getDefaultInstance(properties,new Authenticator(){
		        public PasswordAuthentication getPasswordAuthentication()
		        {
		         return new PasswordAuthentication(from, pws); //发件人邮件用户名、密码 nvktkwfijomibhed
		        }
		       });
		 
		      try{
		         // 创建默认的 MimeMessage 对象
		         MimeMessage message = new MimeMessage(session);
		 
		         // Set From: 头部头字段
		         message.setFrom(new InternetAddress(from,"iLvc.me | 博客系统","UTF-8"));
		 
		         // Set To: 头部头字段
		         message.addRecipient(Message.RecipientType.TO,
		                                  new InternetAddress(email.getToEmail()));
		 
		         // Set Subject: 头部头字段
		         message.setSubject(email.getSubject());
		 
		         // 设置消息体
		         message.setText(email.getContext());
		       
		       
		         // 发送消息
		         Transport.send(message);
		         System.out.println("Sent message successfully....from ilvc.me");
		      }catch (MessagingException mex) {
		         mex.printStackTrace();
		      }
			
		}
		
		
	  
	}
