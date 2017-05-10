package bbPackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNG {

	BB_Auto_Browser br = new BB_Auto_Browser();

	@Test
	public void TC_001() {

		br.checkPageTitle();

	}

	@Test
	public void TC_002() {

		br.addComputer();
	}

	@Test
	public void TC_003() {

		br.totalComputer();
	}

	@Test
	public void TC_004() {

		br.searchComputer();
	}


	@Test
	public void TC_005() {

		br.navigationPlaySampleAppLink();
	}

	@Test
	public void TC_006() {

		br.deleteComputer();
	}

	@Test
	public void TC_007() {

		br.applicationNavigation();
	}

	@Test
	public void TC_008() {

		br.addComputerNameMandatoryFields();
	}

	@Test
	public void TC_009() {

		br.validationHomePageUI();
	}

	@Test
	public void TC_010() {

		br.validationSecondPageUI();
	}

	@Test
	public void TC_011() {

		br.navigationCancel();
	}

	@Test
	public void TC_012() {

		br.updateComputer();
	}

	@BeforeTest
	public void beforeTest() {
		br.setBrowserChrome();

	}

	@AfterTest
	public void afterTest() {
		
		br.closeBrowser();

	}

}
