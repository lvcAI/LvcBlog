package party.pjc.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.series.Bar;

import party.pjc.blog.dao.PostDao;
import party.pjc.blog.model.Post;
import party.pjc.blog.service.ChartService;

@Service
public class ChartServiceImpl implements ChartService{

	@Autowired
	private PostDao postDao;
	
	@Override
	public Option postClick() {
		
		List<Post> list  = postDao.findAllPost(1);
		
		Option option = new Option();
		option.title("文章阅读量统计图").tooltip(Trigger.axis).legend("点击量(次)");
		option.xAxis(new ValueAxis().boundaryGap(0d, 0.01)); 
		CategoryAxis category = new CategoryAxis();
		Bar bar = new Bar("点击量(次)");
		for(Post post : list  ){
			category.data(post.getTitle());
			bar.data(post.getRate());
		}
		option.yAxis(category);
		option.series(bar);
		return option;
	}

}
