package bbPackage;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {

	BB_Auto_Browser br = new BB_Auto_Browser();

	@Test
	public void TC_001() {
		System.out.println("********  Started Executing TC_001: Verify the page title **************");
		br.checkPageTitle();
		System.out.println("********  End of Test Case TC_001 **************\n");

	}

	@Test
	public void TC_002() {
		System.out.println("********  Started Executing TC_002: Add a New Computer **************");
		br.addComputer();
		System.out.println("********  End of Test Case TC_002 **************\n");
	}

	@Test
	public void TC_003() {
		System.out.println("********  Started Executing TC_003: Verify Total number of computers displayed **************");
		br.totalComputer();
		System.out.println("********  End of Test Case TC_003 **************\n");
	}

	@Test
	public void TC_004() {
		System.out.println("********  Started Executing TC_004: Search a Computer **************");
		br.searchComputer();
		System.out.println("********  End of Test Case TC_004 **************\n");
	}


	@Test
	public void TC_005() {
		System.out.println("********  Started Executing TC_005: navigate Sample App Link **************");
		br.navigationPlaySampleAppLink();
		System.out.println("********  End of Test Case TC_005 **************\n");
	}

	@Test
	public void TC_006() {
		System.out.println("********  Started Executing TC_006: Verify the page title **************");
		br.deleteComputer();
		System.out.println("********  End of Test Case TC_006 **************\n");
	}

	@Test
	public void TC_007() {
		System.out.println("********  Started Executing TC_007: Application Navigation **************");
		br.applicationNavigation();
		System.out.println("********  End of Test Case TC_007 **************\n");
	}

	@Test
	public void TC_008() {
		System.out.println("********  Started Executing TC_008: Check Mandatory check while adding new computer **************");
		br.addComputerNameMandatoryFields();
		System.out.println("********  End of Test Case TC_008 **************\n");
	}

	@Test
	public void TC_009() {
		System.out.println("********  Started Executing TC_009: Home Page UI Validation Check **************");
		br.validationHomePageUI();
		System.out.println("********  End of Test Case TC_009 **************\n");
	}

	@Test
	public void TC_010() {
		System.out.println("********  Started Executing TC_010: Second Page UI Validation Check **************");
		br.validationSecondPageUI();
		System.out.println("********  End of Test Case TC_010 **************\n");
	}

	@Test
	public void TC_011() {
		System.out.println("********  Started Executing TC_011: Cancel Button Navigation **************");
		br.navigationCancel();
		System.out.println("********  End of Test Case TC_011 **************\n");
	}

	@Test
	public void TC_012() {
		System.out.println("********  Started Executing TC_012: Update Computer Operation **************");
		br.updateComputer();
		System.out.println("********  End of Test Case TC_012 **************\n");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("********  Opening to Browser Chrome **************");
		br.setBrowserChrome();

	}

	@AfterTest
	public void afterTest() {
		br.closeBrowser();
		System.out.println("******** Closing Browser. **************");
	}

}
