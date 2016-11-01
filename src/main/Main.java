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
import com.swapit.ws.relate.PropositionRelate;

public class Main {

	public static void main(String []args)  {
		
		/*PropositionRelate propRelate = new PropositionRelate();
		propRelate.relate();
		
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
		
		PersonReduce personReduce = personCtrl.getTestReduce("eb072616-bd09-43f8-ad28-c101175bb72f");
				
		
		
		AddressModel addresModel =  new AddressModel(UUID.randomUUID().toString(), streetModel);
		CategoryModel catModelInt = new CategoryModel(UUID.randomUUID().toString(), "QueroTeste", null, "Red", "zip");
		CategoryModel catModel = new CategoryModel();
		catModel = new CategoryModel("fe48be29-90ef-448c-aebc-4cd4fa25713b", "moto", "5b026fc4-cb63-4559-96bf-d8f6910281bb", "red", "icon");
		
		
		
		//PersonModel personModel = personCtrl.getTest("eb072616-bd09-43f8-ad28-c101175bb72f");
		
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
																"Quero",
																"Teste Q",
																addressReduce,
																10.0,
																10.0,
																10.0,
																catModel,
																"fe48be29-90ef-448c-aebc-4cd4fa25713b",
																personReduce,
																 null,
																 null,
																 null);
		
		
		
		
		
		System.out.println(propCtrl.save(propoReduce));
		
		
		*/
		
		
		
		//CategoryModel catModelI = new CategoryModel(null, "moto", null, "Red", "zip");
		
		//CategoryModel catModel = new CategoryModel(null, "Veiculos", null, "Red", "zip");
		
		//CategoryController catCtrl = new CategoryController();
		//System.out.println(catCtrl.save(catModelI));
		
		
	}
	
}
