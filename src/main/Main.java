package main;

import com.swapit.ws.controller.PersonController;
import com.swapit.ws.controller.StreetController;
import com.swapit.ws.model.AddressModel;
import com.swapit.ws.model.PersonModel;
import com.swapit.ws.model.StreetModel;


public class Main {
	
	public static void main(String []args)  {
		
		PersonController personCtrl = new PersonController();
		StreetController streetCtrl = new StreetController();
		
		
		
		
		
		AddressModel address = new AddressModel(null,
				streetCtrl.getByCEP("58067073"), "555");
		
		
		
		//Boolean i = personCtrl.save(new PersonModel(null, "Joab", "joab.bremer@gmail.com", "96447503", "123456",'M',0,"admin",null,address));
		Boolean i = personCtrl.update(new PersonModel("eb072616-bd09-43f8-ad28-c101175bb72f", "Joab", "joab.bremer@gmail.com", "96447503", "123456",'M',0,"admin",null,address));
		System.out.println(i);
		
		//String person = personCtrl.getALL();		
		//System.out.println(personCtrl.getALL());
		
		
		
		
		//System.out.println(streetCtrl.getByCEP("58067073"));;
		
		
		
	}

}
