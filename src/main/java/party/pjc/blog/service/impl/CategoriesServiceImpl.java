package party.pjc.blog.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import party.pjc.blog.dao.CategoriesDao;
import party.pjc.blog.model.Categories;
import party.pjc.blog.service.CategoriesService;

@Service("categoriesService")
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoriesDao categoriesDao;
	
	

	@Override
	public int updateCategories(int id) {
		
		return 0;
	}

	@Override
	public int deleteCategories(int id) {
		
		return 0;
	}

	@Override
	public List<Categories> findAllCategories() {
		
		return this.categoriesDao.findAllCategories();
	}

	@Override
	public int insertCategories(party.pjc.blog.model.Categories categories) {
		
		return this.categoriesDao.insertCategories(categories);
	}

	@Override
	public Categories findPostByCategorise(String categoriesName) {
		
		return this.categoriesDao.findPostByCategorise(categoriesName);
	}

	@Override
	public Categories findCategoriesByName(String cateName) {
		
		return this.categoriesDao.findCategoriesByName(cateName);
	}

	@Override
	public int findPostCountByCate(Categories categories) {
		
		return this.categoriesDao.findPostCountByCate(categories);
	}

	
}
