package main;

import com.swapit.ws.controller.PersonController;
import com.swapit.ws.model.PersonModel;


public class Main {
	
	public static void main(String []args)  {
		
		PersonController personCtrl = new PersonController();
			
		Boolean i = personCtrl.save(new PersonModel(null, "Joab", "joab.bremer@gmail.com", "96447503", "123456",0));
		
		//System.out.println(i);
		
		//String person = personCtrl.getALL();		
		//System.out.println(personCtrl.getALL());
		
		
		
	}

}
