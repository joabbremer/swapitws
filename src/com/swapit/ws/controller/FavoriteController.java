package com.swapit.ws.controller;

import java.util.ArrayList;
import java.util.List;

import com.swapit.ws.entities.Favorite;
import com.swapit.ws.model.FavoriteModel;

public class FavoriteController {
	
		
	public List<FavoriteModel> toModel(List<Favorite> FavoriteEntity){
		List<FavoriteModel> favoriteModel = new ArrayList<>();
		for (Favorite favorite : FavoriteEntity) {
			favoriteModel.add(new FavoriteModel(favorite.getPersonId(),
					favorite.getPropositionId()));
		}
		
		return favoriteModel;
		
	};
	
	public List<Favorite> toEntity(List<FavoriteModel> favoriteModel){
		List<Favorite> favorite = new ArrayList<Favorite>();
		for (FavoriteModel favoriteM : favoriteModel) {
			favorite.add(new Favorite(favoriteM.getPersonId(), favoriteM.getPropositionId()));
		}
		return favorite;
	};

}
