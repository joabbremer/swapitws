package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.List;

import com.swapit.ws.entities.Category;
import com.swapit.ws.model.CategoryModel;

public class CategoryController {
	
	public List<CategoryModel> toModel(List<Category> categoryEntity){
		List<CategoryModel> categoryModel = new ArrayList<>();
		for (Category category : categoryEntity) {
			categoryModel.add(new CategoryModel(category.getCategoryId(),
					category.getCategoryName(),
					category.getParentId(),
					category.getColor(),
					category.getIcon()));
		}
		
		return categoryModel;
	};
	
	
	
	

}
