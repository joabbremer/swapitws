package main;

import com.swapit.ws.controller.PersonController;
import com.swapit.ws.controller.PropositionController;
import com.swapit.ws.controller.StreetController;
import com.swapit.ws.model.AddressModel;
import com.swapit.ws.model.CategoryModel;
import com.swapit.ws.model.PersonModel;
import com.swapit.ws.model.PropositionModel;
import com.swapit.ws.model.StreetModel;


public class Main {
	
	public static void main(String []args)  {
		
		PropositionController propCtrl = new PropositionController();
		StreetController streetCtrl = new StreetController();
		PersonController personCtrl = new PersonController();
		
		StreetModel streetModel = streetCtrl.getByCEP("25815590");
		
		
		
		AddressModel addresModel =  new AddressModel("", streetModel);
		
		CategoryModel catModel = new CategoryModel("", "Teste", null, "White", "icon");
		CategoryModel catModelInt = new CategoryModel("", "QueroTeste", null, "Red", "zip");
		
		PersonModel personModel = new PersonModel();
		
		PropositionModel propModel = new PropositionModel("",
												"TESTE",
												"TESTE T",
												addresModel,
												 10.0,
												 10.0,
												 20.0,
												 catModel,
												 catModelInt,
												 null, image, publish_date, removel_date)
		
		
		
		
		
		System.out.println(propCtrl.save(propModel));;
		
		
		
	}

}
