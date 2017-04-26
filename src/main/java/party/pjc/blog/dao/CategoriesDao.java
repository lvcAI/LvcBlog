package party.pjc.blog.dao;

import java.util.List;

import party.pjc.blog.model.Categories;
import party.pjc.blog.model.Tags;

public interface CategoriesDao {

	public List<Categories> findAllCategories();
	
	public int insertCategories(Categories categories);

	public int updateCategories(int id);
	
	public int deleteCategories(int id);
	public Categories findCategoriesByName(String cateName);
	public Categories findPostByCategorise(String categoriesName);
	public int findPostCountByCate(Categories categories);
	}
