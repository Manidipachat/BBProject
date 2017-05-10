package bbPackage;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import org.testng.Reporter;

import org.openqa.selenium.chrome.ChromeDriver;

public class BB_Auto_Browser {

	WebDriver driver1;

	@BeforeSuite

	/**
	 *   Set the browser to chrome and open the browser
	 */
	public void setBrowserChrome() {

		try {
//			System.setProperty("webdriver.chrome.driver", "\"/path/to/chromedriver\"");
			driver1 = new ChromeDriver();
			driver1.get("http://computer-database.herokuapp.com/computers");
			driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} catch (Exception e) {
			throw new IllegalStateException("Can't start Web Driver", e);

		}

	}

	/**
	 *   Close the Boweser
	 */
	public void closeBrowser() {

		try {
			driver1.quit();

		} catch (Exception e) {
			throw new IllegalStateException("Can't close Web Driver", e);

		}

	}


	/**
	 *  Getting page title from Application homepage
 	 */

	@Test
	public void checkPageTitle() {

		try {
			String actualTitle = driver1.getTitle();
			String expectedTitle = "Computers database";
			Assert.assertEquals(expectedTitle, actualTitle);
			System.out.println("Actual Title is - " + actualTitle);
			Reporter.log("<br>Web Page title displayed as Computers database </br>");
		} catch (Exception e) {
			throw new IllegalStateException("Can't get title", e);

		}

	}

	/**
	 *  Basic CRUD operation - Add a new computer to the Entry
 	 */


	public boolean addComputer() {

		try {
			driver1.findElement(By.id("add")).click();
			driver1.findElement(By.xpath("//*[contains(text(),'Add a computer')]")).isDisplayed();
			driver1.findElement(By.name("name")).sendKeys("tttts");
			driver1.findElement(By.name("introduced")).sendKeys("2017-07-07");
			driver1.findElement(By.name("discontinued")).sendKeys("2019-09-09");
			Select dropdown = new Select(driver1.findElement(By.id("company")));
			dropdown.selectByIndex(2);
			driver1.findElement(By.xpath("//*[@type='submit' ]")).submit();
			if (driver1.findElement(By.xpath("//div[contains(.,'has been created')]")).isDisplayed()) {
				Reporter.log("<br>New Computer Added Suucessfully</br>");
				return true;

			} else {
				Reporter.log("<br>cant ADD computer</br>");
				return false;
			}
		} catch (Exception e) {
			throw new IllegalStateException("<br>cant ADD computer</br>", e);

		}

	}

	/**
	 *  Basic CRUD Operation - Delete a computer from the list
 	 */

	public void deleteComputer() {

		try {

			driver1.findElement(By.id("searchbox")).sendKeys("tttts");
			Thread.sleep(1000);
			driver1.findElement(By.xpath("//*[@id='searchsubmit']")).submit();
			Thread.sleep(1000);
			driver1.findElement(By.xpath("//*[contains(text(),'tttts')]")).click();
			driver1.findElement(By.xpath("//*[@value='Delete this computer']")).click();
			String actualTitle = driver1.findElement(By.xpath("//*[@id='main']/div[1]")).getText();
			System.out.println(actualTitle);
			String expectedTitle = "Done! Computer has been deleted";
			Assert.assertEquals(expectedTitle, actualTitle);
			System.out.println("actualTitle is - " + actualTitle);
			Reporter.log("<br>Computer has been deleted with message - Done! Computer has been deleted</br> ");

		} catch (Exception e) {
			throw new IllegalStateException("<br>cant delete computer</br>", e);

		}

	}

	/**
	 *  Basic CRUD Operation - Retrieve - Search an Entry
 	 */
	public void searchComputer() {

		try {

			driver1.findElement(By.id("searchbox")).sendKeys("tttts");
			Thread.sleep(1000);
			driver1.findElement(By.xpath("//*[@id='searchsubmit']")).submit();
			Thread.sleep(1000);
			driver1.findElement(By.xpath("//*[contains(text(),'tttts')]")).click();
			String name = driver1.findElement(By.name("name")).getAttribute("value");
			System.out.println(name);
			Reporter.log("<br>Computer name /br> " + name);
			String Date1 = driver1.findElement(By.name("introduced")).getAttribute("value");
			System.out.println(Date1);
			Reporter.log("<br>Computer introduced date /br> " + Date1);
			String Date2 = driver1.findElement(By.name("discontinued")).getAttribute("value");
			System.out.println(Date2);
			Reporter.log("<br>Computer discontinued date /br> " + Date2);
			Select archiveList = new Select(driver1.findElement(By.id("company")));
			String selectedValue = archiveList.getFirstSelectedOption().getText();
			System.out.println(selectedValue);
			Reporter.log("<br>Company name /br> " + selectedValue);
			Reporter.log("<br>Computer details Read</br> ");
			driver1.findElement(By.xpath("//*[@id='main']/form/div/a")).click();

		} catch (Exception e) {
			throw new IllegalStateException("cant search computer", e);

		}

	}

	/**
	 *  Basic CRUD Operation - Update an entry
	 */
	public void updateComputer() {

		try {

			driver1.findElement(By.id("searchbox")).sendKeys("tttts");
			Thread.sleep(1000);
			driver1.findElement(By.xpath("//*[@id='searchsubmit']")).submit();
			Thread.sleep(1000);
			driver1.findElement(By.xpath("//*[contains(text(),'tttts')]")).click();
			driver1.findElement(By.name("discontinued")).clear();
			driver1.findElement(By.name("discontinued")).sendKeys("2039-12-09");
			driver1.findElement(By.xpath("//*[@value ='Save this computer']")).click();
			// JavascriptExecutor js = (JavascriptExecutor) driver1;
			// js.executeScript("window.document.getElementByxpath('//*[@id='main']/form[1]/div/input').click()");
			String actualTitle = driver1.findElement(By.xpath("//*[@id='main']/div[1]")).getText();
			System.out.println(actualTitle);
			if (driver1.findElement(By.xpath("//div[contains(.,'has been updated')]")).isDisplayed()) {
				System.out.println("Transaction successful");
				Reporter.log("<br>Computer has been updated</br>");
			}

			else {
				Reporter.log("<br>cant search computer</br>");
			}

		} catch (Exception e) {
			throw new IllegalStateException("cant update computer", e);

		}

	}

	/**
	 *  Page Navigation
 	 */
	public void applicationNavigation() {

		try {

			driver1.findElement(By.xpath("//*[contains(text(),'Next')]")).isDisplayed();
			driver1.findElement(By.xpath("//*[contains(text(),'Next')]")).click();
			driver1.findElement(By.xpath("//*[contains(text(),'Next')]")).click();
			if (driver1.findElement(By.xpath("//*[contains(text(),'Previous')]")).isDisplayed()) {
				driver1.findElement(By.xpath("//*[contains(text(),'Previous')]")).click();
				Reporter.log("<br>Application navigation successful - links working fine</br>");
			} else {
				Reporter.log("<br>Cant navigate</br>");
			}

		} catch (Exception e) {
			throw new IllegalStateException("Cant navigate", e);

		}

	}

	/**
	 *  Cancel Button Action
 	 */
	public void navigationCancel() {

		try {

			driver1.findElement(By.xpath("//*[@id='add']")).click();
			Reporter.log("<br>Add computer Page </br>");
			Thread.sleep(2000);
			driver1.findElement(By.xpath("//*[@id='main']/form/div/a")).click();
			Reporter.log("<br>cancel button is displayed</br>");
			if (driver1.findElement(By.id("add")).isDisplayed()) {
				Reporter.log("<br>Clicked on cancel button and back to homepage</br>");
			} else {
				Reporter.log("<br>Cant navigate</br>");
			}

		} catch (Exception e) {
			throw new IllegalStateException("Cant navigate", e);

		}

	}

	/**
	 *  PlaySampleAppLink Navigation operation
	 */

	public void navigationPlaySampleAppLink() {

		try {

			driver1.findElement(By.xpath("//*[@id='add']")).click();
			Thread.sleep(2000);
			if (driver1.findElement(By.xpath("//*[contains(text(),'Add a computer')]")).isDisplayed()) {
				Reporter.log("<br>Add a computer page is displayed</br>");
				if (driver1.findElement(By.xpath("//a[contains(text(),'Play sample application — Computer database')]"))
						.isDisplayed()) {
					Reporter.log("<br>Play sample application — Computer database is displayed</br>");
					driver1.findElement(By.xpath("//a[contains(text(),'Play sample application — Computer database')]"))
							.click();
					if (driver1.findElement(By.id("add")).isDisplayed()) {
						Reporter.log(
								"<br>Play sample application — Computer database link is clicked And Back to home page</br>");
					}

				}
			} else {
				Reporter.log("<br>Not displayed</br>");
			}
		}

		catch (Exception e) {
			throw new IllegalStateException("Cant navigate", e);

		}

	}

	/**
	 *  Add Computer : Check if Computer Name is Mandatory
 	 */
	public void addComputerNameMandatoryFields() {

		try {
			driver1.findElement(By.id("add")).click();
			driver1.findElement(By.xpath("//*[contains(text(),'Add a computer')]")).isDisplayed();
			driver1.findElement(By.name("introduced")).sendKeys("2017-07-07");
			driver1.findElement(By.name("discontinued")).sendKeys("2019-09-09");
			Select dropdown = new Select(driver1.findElement(By.id("company")));
			dropdown.selectByIndex(3);
			driver1.findElement(By.xpath("//*[@type='submit' ]")).submit();
			Thread.sleep(2000);
			if (driver1
					.findElement(
							By.xpath("//*[contains(text(),'Computer name')]/following::span[contains(.,'Required')]"))
					.isDisplayed()) {
				Reporter.log("<br>name is the mandatory field for adding new computer</br>");
			} else {
				Reporter.log("<br>something's wrong- please check</br>");
			}

			driver1.findElement(By.name("name")).sendKeys("AutoQA");
			Thread.sleep(2000);
			driver1.findElement(By.xpath("//*[@type='submit' ]")).submit();

			if (driver1.findElement(By.xpath("//div[contains(.,'has been created')]")).isDisplayed()) {
				Reporter.log("<br>New Computer Added Suucessfully</br>");
			} else {
				Reporter.log("<br>cant ADD computer</br>");
			}

		} catch (Exception e) {
			throw new IllegalStateException("cant ADD computer", e);

		}

	}

	/**
	 *  UI validation homepage
 	 */

	public void validationHomePageUI() {

		try {
			Reporter.log("<br>Home Page UI validation</br>");

			if (driver1.findElement(By.xpath("//a[contains(text(),'Play sample application — Computer database')]"))
					.isDisplayed()) {
				Reporter.log("<br>Play sample application — Computer database is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}

			if (driver1.findElement(By.id("searchbox")).isDisplayed()) {
				Reporter.log("<br>Searchbox is displayed</br>");
			}

			else {
				Reporter.log("<br>NOT displayed</br>");
			}

			if (driver1.findElement(By.xpath("//*[@id='searchsubmit']")).isDisplayed()) {
				Reporter.log("<br>Filter by name button is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}

			if (driver1.findElement(By.xpath("//*[contains(text(),'Add a new computer')]")).isDisplayed()) {
				Reporter.log("<br>Add a computer button is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}

			if (driver1.findElement(By.xpath("//*[contains(text(),'Computer name')]")).isDisplayed()) {
				Reporter.log("<br>Computer name column is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}

			if (driver1.findElement(By.xpath("//*[contains(text(),'Introduced')]")).isDisplayed()) {
				Reporter.log("<br>Introduced column is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}

			if (driver1.findElement(By.xpath("//*[contains(text(),'Discontinued')]")).isDisplayed()) {
				Reporter.log("<br>Discontinued column is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}

			if (driver1.findElement(By.xpath("//*[contains(text(),'Company')]")).isDisplayed()) {
				Reporter.log("<br>Company column is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}

		} catch (Exception e) {
			throw new IllegalStateException("cant validate homepage objects", e);

		}

	}

	/**
	 *  UI validation secondpage
 	 */
	public void validationSecondPageUI() {

		try {
			driver1.findElement(By.xpath("//*[@id='add']")).click();
			Reporter.log("<br>Add computer Page UI validation</br>");

			if (driver1.findElement(By.xpath("//a[contains(text(),'Play sample application — Computer database')]"))
					.isDisplayed()) {
				Reporter.log("<br>Play sample application — Computer database is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}

			if (driver1.findElement(By.xpath("//*[contains(text(),'Computer name')]")).isDisplayed()) {
				Reporter.log("<br>Computer name heading is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}

			if (driver1.findElement(By.name("name")).isDisplayed()) {
				Reporter.log("<br>Name inputbox is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}

			if (driver1.findElement(By.xpath("//*[contains(text(),'Introduced')]")).isDisplayed()) {
				Reporter.log("<br>Introduced heading is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}

			if (driver1.findElement(By.name("introduced")).isDisplayed()) {
				Reporter.log("<br>introduced inputbox is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}

			if (driver1.findElement(By.xpath("//*[contains(text(),'Discontinued')]")).isDisplayed()) {
				Reporter.log("<br>Discontinued heading is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}

			if (driver1.findElement(By.name("discontinued")).isDisplayed()) {
				Reporter.log("<br>discontinued inputbox is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}

			if (driver1.findElement(By.xpath("//*[contains(text(),'Company')]")).isDisplayed()) {
				Reporter.log("<br>Company heading is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}

			if (driver1.findElement(By.xpath("//*[@id='company']")).isDisplayed()) {
				Reporter.log("<br>Company inputbox is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}

			if (driver1.findElement(By.xpath("//*[@type='submit' ]")).isDisplayed()) {
				Reporter.log("<br>Create this computer button is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}
			if (driver1.findElement(By.xpath("//*[@id='main']/form/div/a")).isDisplayed()) {
				Reporter.log("<br>cancel button is displayed</br>");
			} else {
				Reporter.log("<br>NOT displayed</br>");
			}
			driver1.findElement(By.xpath("//*[@id='main']/form/div/a")).click();

		} catch (Exception e) {
			throw new IllegalStateException("cant validate age objects", e);

		}

	}

	/**
	 *  Total number of computer found
 	 */
	public void totalComputer() {

		try {

			String Text = driver1.findElement(By.xpath("//*[@id='main']/h1")).getText();
			System.out.println("total " + Text);
			Reporter.log("<br>Total number of computers shown</br> " + Text);

		} catch (Exception e) {
			throw new IllegalStateException("Cant view number of computers", e);

		}

	}

}
