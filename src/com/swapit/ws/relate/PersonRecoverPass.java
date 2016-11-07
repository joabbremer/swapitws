package com.swapit.ws.relate;

import java.util.List;

import com.swapit.ws.controller.PersonController;
import com.swapit.ws.model.PersonModel;
import com.swapit.ws.service.SendMail;

public class PersonRecoverPass extends Thread implements Runnable {
	
	public void run() {
		try {
			while (true) {		
				
				sendMailForRecoverPass();
				Thread.sleep(MAX_PRIORITY);;// 300000 5 minutos
			}			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private void sendMailForRecoverPass() {
		PersonController personCtrl = new PersonController();
		SendMail sendMail = new SendMail();
		List<PersonModel> perModelList = personCtrl.getForActive();
		for (PersonModel personModel : perModelList) {
			if(personModel.getBlocked() == 3){
				sendMail.sendMailRecoverPass(personModel.getEmail(), personModel.getPersonId());
				personModel.setBlocked(0);
				personCtrl.updateService(personModel);
			}
		}
		
	}

}
