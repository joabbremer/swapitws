package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;
import com.swapit.ws.dao.CategoryDAO;
import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Category;
import com.swapit.ws.model.CategoryModel;

public class CategoryController {
	
	public String getALL() {
		CategoryDAO catDao = new CategoryDAO();
		List<Category> cat = new ArrayList<Category>();
		try {
			cat = catDao.listAll();
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		return tojson(cat);
		
	};
	
	public String getbyID(String id) {
		CategoryDAO catDao = new CategoryDAO();
		Category cat = null;
		try {
			cat = catDao.select(id);
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		
		return tojson(cat);
	}
	
	public String getParent(String parentID) {
		CategoryDAO catDao = new CategoryDAO();
		List<Category> cat = null;
		try {
			cat = catDao.getParent(parentID);
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		if(cat.size() != 0){
			return tojson(cat);
		}
		return null;
		
	}
	public Category getCatEntityByID(String id) {
		CategoryDAO catDao = new CategoryDAO();
		List<Category> cat = null;
		if(!id.equals("null")){
			try {
				cat = catDao.selectShow(id);
			} catch (ConnectException e) {
				e.printStackTrace();
			}
		}		
		return listToSingle(cat);
	}
	
	private Category listToSingle(List<Category> cat) {
		Category cate = null;
		if(cat.size() > 0){
			for (Category category : cat) {
					cate = new Category(category.getCategoryId(),
										category.getCategoryName(),
										category.getParentId(),
										category.getColor(),
										category.getIcon());
				}
			}
		
		return cate;
	}

	public CategoryModel getModelbyID(String id) {
		CategoryDAO catDao = new CategoryDAO();
		Category cat = null;
		try {
			cat = catDao.select(id);
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		
		return toModel(cat);
	}
	
	public boolean save(CategoryModel categoryModel) {
		CategoryDAO catDao = new CategoryDAO();
		categoryModel = creatID(categoryModel);
		try {
			return catDao.save(toEntity(categoryModel));
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(CategoryModel categoryModel) {
		CategoryDAO catDao = new CategoryDAO();
		try {
			return catDao.update(toEntity(categoryModel));
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		return false;
	}
	


	private CategoryModel creatID(CategoryModel categoryModel) {
		
		categoryModel.setCategoryId(UUID.randomUUID().toString());
		
		return categoryModel;
		
	}

	private String tojson(List<Category> cat) {
		Gson gson = new Gson();
		return gson.toJson(cat);
	}
	
	private String tojson(Category cat) {
		Gson gson = new Gson();
		return gson.toJson(cat);
	}

	public CategoryModel toModel(Category category ){
		if(category != null){
			return 	new CategoryModel(category.getCategoryId(),
					category.getCategoryName(),
					category.getParentId(),
					category.getColor(),
					category.getIcon());
		}
		return null;
		
	}


	public List<CategoryModel> toModelList(List<Category> categoryEntity){
		List<CategoryModel> categoryModel = new ArrayList<>();
		for (Category category : categoryEntity) {
			categoryModel.add(new CategoryModel(category.getCategoryId(),
					category.getCategoryName(),
					category.getParentId(),
					category.getColor(),
					category.getIcon()));
		}
		
		return categoryModel;
	}

	public Category toEntity(CategoryModel category) {
		if(category != null){
			return new Category(category.getCategoryId(),
					category.getCategoryName(),
					category.getParentId(),
					category.getColor(),
					category.getIcon());
			
		}
		return null;
		
	}
	
	

	public List<Category> toEntityList(List<CategoryModel> categoryModel){
		List<Category> category = new ArrayList<Category>();
		if(categoryModel != null){
			for (CategoryModel catModel : categoryModel) {
				category.add(new Category(catModel.getCategoryId(),
											catModel.getCategoryName(),
											catModel.getParentId(),
											catModel.getColor(),
											catModel.getIcon()));
					
				
			}
		}
		
		return category;
	}


	





	
	
	
	
	

}
