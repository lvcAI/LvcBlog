package party.pjc.blog.lucene;

import java.io.File;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import party.pjc.blog.model.Post;
import party.pjc.blog.util.DateUtil;
import party.pjc.blog.util.FileUtil;
import party.pjc.blog.util.StringUtil;



/**
 * 处理post 索引类
 * @author lvc
 *
 */
public class PostIndex {
private Directory dir=null;
	

	/**
	 * 获取IndexWriter实例
	 * @return
	 * @throws Exception
	 */
	private IndexWriter getWriter()throws Exception{
	
		
		if(System.getProperty("os.name").toLowerCase().equals("windows 10")){
			dir=FSDirectory.open(Paths.get("D://lucene")); 		//windows 下
		}else{
			dir=FSDirectory.open(Paths.get("//lucene"));		// linux 
		}
		 
		SmartChineseAnalyzer analyzer=new SmartChineseAnalyzer();
		IndexWriterConfig iwc=new IndexWriterConfig(analyzer);
		IndexWriter writer=new IndexWriter(dir, iwc);
		return writer;
	}
	
	/**
	 * 添加博客索引
	 * @param Post
	 */
	public void addIndex(Post post)throws Exception{
		IndexWriter writer=getWriter();
		Document doc=new Document();
		doc.add(new StringField("id",String.valueOf(post.getId()),Field.Store.YES));
		doc.add(new TextField("title",post.getTitle(),Field.Store.YES));
		doc.add(new StringField("releaseDate",DateUtil.formatDate(new Date(), "yyyy-MM-dd"),Field.Store.YES));
		doc.add(new TextField("content",StringUtil.removeTag(post.getHtml()),Field.Store.YES));
		writer.addDocument(doc);
		writer.close();
	}
	
	/**
	 * 更新博客索引
	 * @param Post
	 * @throws Exception
	 */
	public void updateIndex(Post post)throws Exception{
		IndexWriter writer=getWriter();
		Document doc=new Document();
		doc.add(new StringField("id",String.valueOf(post.getId()),Field.Store.YES));
		doc.add(new TextField("title",post.getTitle(),Field.Store.YES));
		doc.add(new StringField("releaseDate",DateUtil.formatDate(new Date(), "yyyy-MM-dd"),Field.Store.YES));
		doc.add(new TextField("content",StringUtil.removeTag(post.getHtml()),Field.Store.YES));
		writer.updateDocument(new Term("id", String.valueOf(post.getId())), doc);
		writer.close();
	}
	
	/**
	 * 删除指定博客的索引
	 * @param PostId
	 * @throws Exception
	 */
	public void deleteIndex(String postId)throws Exception{
		IndexWriter writer=getWriter();
		writer.deleteDocuments(new Term("id",postId));
		writer.forceMergeDeletes(); // 强制删除
		writer.commit();
		writer.close();
	}
	
	/**
	 * 查询博客信息
	 * @param q 查询关键字
	 * @return
	 * @throws Exception
	 */
	public List<Post> searchPost(String q)throws Exception{
		//判断操作系统
		if(System.getProperty("os.name").toLowerCase().equals("windows 10")){
			dir=FSDirectory.open(Paths.get("D://lucene")); 		//windows 下
		}else{
			dir=FSDirectory.open(Paths.get("//lucene"));		// linux 
		}
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher is=new IndexSearcher(reader);
		BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder(); //用于多条件查询
		SmartChineseAnalyzer analyzer=new SmartChineseAnalyzer();
		QueryParser parser=new QueryParser("title",analyzer);
		Query query=parser.parse(q);
		QueryParser parser2=new QueryParser("content",analyzer);
		Query query2=parser2.parse(q);
		booleanQuery.add(query,BooleanClause.Occur.SHOULD);
		booleanQuery.add(query2,BooleanClause.Occur.SHOULD);
		TopDocs hits=is.search(booleanQuery.build(), 100);		//分页 显示，只要100条
		QueryScorer scorer=new QueryScorer(query);  
		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);  
		SimpleHTMLFormatter simpleHTMLFormatter=new SimpleHTMLFormatter("<b><font color='red'>","</font></b>");
		Highlighter highlighter=new Highlighter(simpleHTMLFormatter, scorer);
		highlighter.setTextFragmenter(fragmenter);  
		List<Post> PostList=new LinkedList<Post>();
		for(ScoreDoc scoreDoc:hits.scoreDocs){
			Document doc=is.doc(scoreDoc.doc);
			Post post=new Post();
			post.setId(Integer.parseInt(doc.get(("id"))));
			post.setReleaseDate(doc.get(("releaseDate")));
			String title=doc.get("title");
			String content=StringEscapeUtils.escapeHtml(doc.get("content"));
			if(title!=null){
				TokenStream tokenStream = analyzer.tokenStream("title", new StringReader(title));
				String hTitle=highlighter.getBestFragment(tokenStream, title);
				if(StringUtil.isEmpty(hTitle)){
					post.setTitle(title);
				}else{
					post.setTitle(hTitle);					
				}
			}
			if(content!=null){
				TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(content)); 
				String hContent=highlighter.getBestFragment(tokenStream, content);
				if(StringUtil.isEmpty(hContent)){
					if(content.length()<=200){
						post.setContent(content);
					}else{
						post.setContent(content.substring(0, 200));						
					}
				}else{
					post.setContent(hContent);					
				}
			}
			PostList.add(post);
		}
		return PostList;
	}
}
