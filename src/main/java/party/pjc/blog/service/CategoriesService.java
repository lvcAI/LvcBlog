package party.pjc.blog.service;

import java.util.List;

import party.pjc.blog.model.Categories;
import party.pjc.blog.model.vo.CountResult;



public interface CategoriesService {
	
	public List<Categories> findAllCategories();
	public int insertCategories(Categories categories);

	public int updateCategories(int id);
	
	public int deleteCategories(int id);
	public Categories findPostByCategorise(String categoriesName);
	public Categories findCategoriesByName(String cateName);
	
	public int findPostCountByCate(Categories categories);
	public List<CountResult> findPostCountByCates();
}
