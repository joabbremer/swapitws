package com.swapit.ws.relate;

import java.util.List;

import com.swapit.ws.controller.PersonController;
import com.swapit.ws.model.PersonModel;
import com.swapit.ws.service.SendMail;

public class PersonActiveRelate extends Thread implements Runnable {
	
	
	public void run() {
		try {
			while (true) {		
				
				sendMailForActive();
				Thread.sleep(300000);// 300000 5 minutos
			}			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private void sendMailForActive() {
		PersonController personCtrl = new PersonController();
		SendMail sendMail = new SendMail();
		List<PersonModel> perModelList = personCtrl.getForActive();
		for (PersonModel personModel : perModelList) {
			if(personModel.getBlocked() == 1){
				sendMail.sendMailActive(personModel.getEmail(), personModel.getPersonId());
				personModel.setBlocked(2);
				personCtrl.updateService(personModel);
			}
		}
		
			
			
			
			
		
	}
	

}
