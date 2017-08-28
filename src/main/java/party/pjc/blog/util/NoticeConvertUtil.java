package party.pjc.blog.util;

import java.util.ArrayList;
import java.util.List;

import com.xiaoleilu.hutool.util.NumberUtil;

import party.pjc.blog.model.Notice;
import party.pjc.blog.service.NoticeService;

/**
 * 
 * @author iLvc
 *	notic 获取相应的随机条数
 */
public class NoticeConvertUtil {
	
	/**
	 * desc 获取随机的notice  
	 * @param <T>
	 * 
	 *  
	 * @return
	 */
	 public static <T> List<Notice> noticeConver(int count,T t){
		 List<Notice> noticeList = new ArrayList<Notice>();
		 NoticeService noticeService = (NoticeService)t;
		 
		 int counts = noticeService.size(null);
		 int[] range = NumberUtil.generateRandomNumber(1, counts, count); 
		 for(int i: range){
			 noticeList.add(noticeService.findNoticeById(i));
		 }
		 
		return noticeList;
	}

}
