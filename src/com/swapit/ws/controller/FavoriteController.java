package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.swapit.ws.entities.Favorite;
import com.swapit.ws.model.FavoriteModel;

public class FavoriteController {
	
	public List<FavoriteModel> toModelList(List<Favorite> favoriteList){
		List<FavoriteModel> favModel = new ArrayList<FavoriteModel>();
		for (Favorite favorite : favoriteList) {
			favModel.add(new FavoriteModel(favorite.getFavoriteid(),
					favorite.getPersonid(),
					 favorite.getPropositionid()));
			
		}
		return favModel;
	}
	
	public List<Favorite> toEntityList(List<FavoriteModel> favoriteModelList){
		List<Favorite> favorite = new ArrayList<>();		
		for (FavoriteModel favoriteModel : favoriteModelList) {
			favorite.add(new Favorite(favoriteModel.getFavoriteid(),
					favoriteModel.getPersonid(),
					favoriteModel.getPropositionid()));
		}
		return favorite;
	}

	public List<FavoriteModel> cretID(List<FavoriteModel> favModel) {
		List<FavoriteModel> favModelReturn = new ArrayList<FavoriteModel>();
		for (FavoriteModel favoriteModel : favModel) {
			
			if(favoriteModel.getFavoriteid() == null){
				favoriteModel.setFavoriteid(UUID.randomUUID().toString());
			}
			
			favModelReturn.add(new FavoriteModel(favoriteModel.getFavoriteid(),
												favoriteModel.getPersonid(),
												favoriteModel.getPropositionid()));
		}
		return favModelReturn;
	}

}
