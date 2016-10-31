package com.swapit.ws.relate;

import java.util.ArrayList;
import java.util.List;

import com.swapit.ws.controller.PropositionController;
import com.swapit.ws.model.PropositionModel;

public class PropositionRelate {
	
	
	
	public void relate(){
		PropositionController propCtrl = new PropositionController();
		List<PropositionModel> propModelHave = propCtrl.getForRelate();
		
		
		List<PropositionModel> propModelInterest = propModelHave;
		List<PropositionModel> propModelSend = new ArrayList<>();
		
		for (PropositionModel propositionModelHave : propModelHave) {
			for (PropositionModel propositionModelInterst : propModelInterest) {
				String have = propositionModelHave.getInterest_category().getCategoryId();
				String has = propositionModelInterst.getCategory().getCategoryId();
				if(has!=null){
					if(has.equals(have)){
						System.out.println(propositionModelHave.getTitle() + " QUER " + propositionModelInterst.getTitle());
						propModelSend.add(propositionModelInterst);
						//enviar pera para abacaxi a pera
					}
				}
				
				
			}
			sendInterest(propModelSend);
		}
		
		for (PropositionModel propositionModel : propModelSend) {
			System.out.println(propositionModel.getTitle());
		}
		
		
		
		
	}

	private void sendInterest(List<PropositionModel> propModelSend) {
		// varer lista
		//montar e-mail e enviar
		
	}
	
}
