package cts.automation.courseraWebAutomation.execute;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cts.automation.courseraWebAutomation.CoursesOffered;
import cts.automation.courseraWebAutomation.ForEnterprise;
import cts.automation.courseraWebAutomation.TotalCount;

public class TestCases 
{
	static WebDriver driver;
	CoursesOffered coursesOffered;
	ForEnterprise forEnterprise;
	TotalCount totalCount;
	Properties properties;
	String browserName;
	
	@BeforeClass
	@Parameters({"browserName"})
	
	  public void beforeClass(@Optional("chrome")String browserName) throws Exception
	  {
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//driver//chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//driver//geckodriver.exe");  
			driver = new FirefoxDriver();
		}
	  }

	  
	@Test (priority=0)
	public void coursesSearched() throws InterruptedException, IOException 
	{
		coursesOffered=new CoursesOffered(driver);
		coursesOffered.totalCoursesOffered();
		
	}
	
	@Test (priority=2)
	public void errorMessage() throws InterruptedException, IOException{
	try {
		{
			forEnterprise=new ForEnterprise(driver);
			forEnterprise.errorMessageAtEnterprise();
		}
	} catch (InterruptedException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
	
	
	@Test (priority=1)
	public void totalCourses() throws InterruptedException, IOException
	{
		totalCount=new TotalCount(driver);
		totalCount.totalCountOfCourses();
	}
	

	 @AfterClass
	 public void afterClass() 
	 {
		driver.quit();
	 }
	
}
