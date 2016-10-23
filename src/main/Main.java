package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.swapit.ws.controller.CategoryController;
import com.swapit.ws.controller.PersonController;
import com.swapit.ws.controller.PropositionController;
import com.swapit.ws.controller.PropositionImageController;
import com.swapit.ws.controller.StreetController;
import com.swapit.ws.model.AddressModel;
import com.swapit.ws.model.CategoryModel;
import com.swapit.ws.model.CityModel;
import com.swapit.ws.model.CountryModel;
import com.swapit.ws.model.DistrictModel;
import com.swapit.ws.model.PersonModel;
import com.swapit.ws.model.PropositionImageModel;
import com.swapit.ws.model.PropositionModel;
import com.swapit.ws.model.StateModel;
import com.swapit.ws.model.StreetModel;
import com.swapit.ws.model.reduce.AddressReduce;
import com.swapit.ws.model.reduce.PersonReduce;
import com.swapit.ws.model.reduce.PropositionReduce;

public class Main {

	public static void main(String []args)  {
		
		PropositionController propCtrl = new PropositionController();
		StreetController streetCtrl = new StreetController();
		PersonController personCtrl = new PersonController();
		PropositionImageController propImgCtrl = new PropositionImageController();
		
		
		
		StreetModel streetModel = streetCtrl.getByCEP("25815590");
		 
		 DistrictModel districtModel = streetModel.getDistrict();
		 CityModel cityModel = districtModel.getCity();
		 StateModel stateModel = cityModel.getState();
		 CountryModel countryModel = stateModel.getCountry();
		
		AddressReduce addressReduce = new AddressReduce(streetModel.getStreetid(),
														streetModel.getZipcode(),
														streetModel.getName(),
														streetModel.getComplement(),
														null,
														districtModel.getName(),
														cityModel.getName(),
														stateModel.getAcronym(),
														stateModel.getName(),
														countryModel.getAcronym(),
														countryModel.getName());
		
		PersonReduce personReduce = personCtrl.getTestReduce("f33df794-9d82-4252-ba4a-e8cf091825d2");
				
		
		
		AddressModel addresModel =  new AddressModel(UUID.randomUUID().toString(), streetModel);
		CategoryModel catModelInt = new CategoryModel(UUID.randomUUID().toString(), "QueroTeste", null, "Red", "zip");
		CategoryModel catModel = new CategoryModel();
		catModel = new CategoryModel("0cf8b190-2799-4dbe-a1db-18f9e9711093", "TESTT", "", "White", "icon");
		
		
		
		PersonModel personModel = personCtrl.getTest("f33df794-9d82-4252-ba4a-e8cf091825d2");
		
		Date date = new Date();
	
		
		List<PropositionImageModel> listimg = new ArrayList<PropositionImageModel>();
		listimg.add(new PropositionImageModel(UUID.randomUUID().toString()));
		listimg.add(new PropositionImageModel(UUID.randomUUID().toString()));
		
		PropositionModel propModel = new PropositionModel(UUID.randomUUID().toString(),
												"TESTE",
												"TESTE T",
												addresModel,
												 10.0,
												 10.0,
												 20.0,
												 catModel,
												 "123456",
												 personModel,
												 listimg,
												 date,
												 date);
		
		PropositionReduce propoReduce = new PropositionReduce(  UUID.randomUUID().toString(),
																"Teste",
																"Teste T",
																addressReduce,
																10.0,
																10.0,
																10.0,
																catModel,
																"123456",
																personReduce,
																 null,
																 null,
																 null);
		
		
		
		
		
		System.out.println(propCtrl.save(propoReduce));
		
		
		
		
		//CategoryModel catModelI = new CategoryModel(null, "Teste", null, "Red", "zip");
		
		//CategoryModel catModel = new CategoryModel(null, "Quero", catModelI, "Red", "zip");
		
		//CategoryController catCtrl = new CategoryController();
		//System.out.println(catCtrl.save(catModel));
		
		
	}

}
