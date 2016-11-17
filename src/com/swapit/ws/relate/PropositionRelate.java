package com.swapit.ws.relate;

import java.util.ArrayList;
import java.util.List;

import com.swapit.ws.controller.PropositionController;
import com.swapit.ws.model.PropositionModel;
import com.swapit.ws.service.SendMail;

public class PropositionRelate extends Thread implements Runnable {
	

	public void run() {
		try {
			while (true) {		
				
				relate();
				Thread.sleep(300000);// 5 minutos
			}			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void relate(){
		System.out.println(">>Iniciando Relacionamento de proposta");
		PropositionController propCtrl = new PropositionController();
		List<PropositionModel> propModelHave = propCtrl.getForRelate();
		
		
		List<PropositionModel> propModelInterest = propModelHave;
		List<PropositionModel> propModelSend = new ArrayList<>();
		
		for (PropositionModel propositionModelHave : propModelHave) {
			boolean canSend = false;
			for (PropositionModel propositionModelInterst : propModelInterest) {
				String have = " ";
				if(propositionModelHave.getInterest_category() != null){
					have = propositionModelHave.getInterest_category().getCategoryId();
				}
				
				String has = propositionModelInterst.getCategory().getCategoryId();
				if(has!=null){
					if(has.equals(have)){
						System.out.println(propositionModelHave.getTitle() + " QUER " + propositionModelInterst.getTitle());
						propModelSend.add(propositionModelInterst);
						canSend = true;
					}
				}
				
				
			}
			if(canSend){
				System.out.println(">>Enviando E-mail para afins");
				sendInterest(propModelSend, propositionModelHave.getPersonId().getEmail());
			}
			
		}

	}

	private void sendInterest(List<PropositionModel> propModelSend, String emailPersonWant) {
		String MSGLOCATION = "Encontramos algumas propostas do seu interesse ";		
	
		for (PropositionModel propModel : propModelSend) {
			
			MSGLOCATION += "<br/>";
			MSGLOCATION += "<a href='"+"http://localhost/sw_app/#/details/"+propModel.getPropositionId()+"'>"+propModel.getTitle()+"</a>";
			
		}
		
		SendMail sendMail = new SendMail();
		sendMail.sendMailListProposition(emailPersonWant ,MSGLOCATION);		
		System.out.println(">>Email Enviado");
		
	}
	

}


