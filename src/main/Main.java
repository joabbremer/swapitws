package main;

import com.swapit.ws.controller.PersonController;
import com.swapit.ws.model.PersonModel;


public class Main {
	
	public static void main(String []args)  {
		
		PersonController personCtrl = new PersonController();
			
		//Boolean i = personCtrl.save(new PersonModel(null, "Joab", "joab.brmer", "999999", "123456", 'M', 0));
		
		//System.out.println(i);
		
		//String person = personCtrl.getALL();		
		System.out.println(personCtrl.getALL());
		
		
		
	}

}
