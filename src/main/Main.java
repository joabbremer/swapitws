package main;

import com.swapit.ws.controller.PersonController;
import com.swapit.ws.model.PersonModel;

public class Main {
	
	public static void main(String []args)  {
		
		PersonController personCtrl = new PersonController();
		Boolean i = personCtrl.save(new PersonModel("Joab"));
		
		System.out.println(i);
		
		
		
		
	}

}
