package omayoBlog.TestCases;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codemindPP.Utility;

import omayo.pages.DemoBlazeResistration;

public class DemoBlazeResistrationTestCase extends BaseTestCase {

	
	DemoBlazeResistration demoBlazeResistration;
	
	@Test(dataProvider = "detaProviderForRegistration")
	public void verifyResistration(String firstname, String lastname, String phone, String email) {
		demoBlazeResistration = new DemoBlazeResistration(driver);
		demoBlazeResistration.getFirstname().sendKeys(firstname);	
		demoBlazeResistration.getLastname().sendKeys(lastname);
		demoBlazeResistration.getPhone().sendKeys(phone);
		demoBlazeResistration.getEmail().sendKeys(email);
		
		
	}
	@DataProvider(name="detaProviderForRegistration")
	public String [][] detaProviderForRegistration(){
		ArrayList<String> arraylist = Utility.readExceldata();
		String array[][] = new String[1][arraylist.size()];
		array[0][0]=arraylist.get(0);
		array[0][1]=arraylist.get(1);
		array[0][2]=arraylist.get(2);
		array[0][3]=arraylist.get(3);
		return array;
	}
	
	
	
}
