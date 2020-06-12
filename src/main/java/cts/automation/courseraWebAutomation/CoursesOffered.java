/**
 * This program searches all the web development courses and applies various filters 
 *  and display the first two courses with name,rating and duration.
 *  @author Plugin Immortals
 *  @since 2020-05-21
 */
package cts.automation.courseraWebAutomation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CoursesOffered 
{

	static WebDriver driver;
	Properties properties;
	
	public CoursesOffered(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void totalCoursesOffered() throws InterruptedException, IOException 
	{
		
		//System.setProperty("webdriver.chrome.driver", "C:/Users/asus/Desktop/Major Project/courseraWebDevelopment/driver/chromedriver.exe");
		//driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//System.out.println(properties.getProperty("course"));
		
		//Searching for the Web Development through text search
		driver.manage().window().maximize();
		driver.get("https://www.coursera.org/search?query=Web+Development&");
		Thread.sleep(2000);
		
		//Filtering all Web Development courses in English language
		String originalUrl = driver.getCurrentUrl();
		String newUrl = originalUrl + "index=prod_all_products_term_optimization";
		String firstFilter = newUrl + "&allLanguages=" + "English";

		//Second filtering all the English languages courses on the basis of Learning Level
		String secondFilter = firstFilter + "&productDifficultyLevel=" + "Beginner";
		driver.get(secondFilter);
		
		//Getting all the courses offered for Web Development after applying filter
		String homePage = driver.getWindowHandle();  //Storing the parent window
		Thread.sleep(3000);
		
		//Making a list of the Courses by initializing a List
		List<WebElement> noOfCourses = driver.findElements(By.xpath("//h2[@class='color-primary-text card-title headline-1-text']"));
		System.out.println("Courses are:");
		
		//Traversing one by one and getting the names of the courses
		for (int i = 0; i < 6; i++) {
			System.out.println(noOfCourses.get(i).getText());
			Thread.sleep(1000);
		}
		System.out.println("-----------------------------------------------------------------");
		Thread.sleep(3000);
		
		//Making a list of the Ratings by initializing a List
		List<WebElement> ratings = driver.findElements(By.xpath("//span[@class='ratings-text']"));
		System.out.println("Ratings  are:");

		//Traversing one by one and getting the ratings of the first three courses
		for (int i = 0; i < 3; i++) {
			int j = i + 1;
			System.out.println(j + "." + ratings.get(i).getText());
			Thread.sleep(1000);
		}
		System.out.println("-----------------------------------------------------------------");
		Thread.sleep(5000);
		
		/*Now getting to the first window to click on every Courses
		 * to get their approximate time at which the 
		 * courses are completed
		 * We take first two courses and find the time taken to complete that 
		 */
		
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		//Properties tabs = null;
		//driver.switchTo().window((String) tabs.get(1));
		
		//Clicking on the first course
		WebElement firstTitle=driver.findElement(By.xpath("(//h2[@class='color-primary-text card-title headline-1-text'])[1]"));
		firstTitle.click();
		Thread.sleep(3000);
		String firstTab=driver.getWindowHandle(); //Storing the second window

		//Switching to the windows to pass the driver
		Set<String> totalTabs = driver.getWindowHandles();	
		Iterator<String> iteration = totalTabs.iterator();
		homePage = iteration.next();
		firstTab = iteration.next();
		Thread.sleep(3000);
		driver.switchTo().window(firstTab); //Switching to the First course
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,800)"); //Window scroll
		Thread.sleep(3000);
		String durationOf1 = driver.findElement(By.xpath("//div[@class='ProductGlance']//span[contains(text(),'Approx. 6 months to complete')]")).getText();
		System.out.println("Duration of 1st Course :  || " + durationOf1);

		driver.close(); //Closing the Tab	
     	Thread.sleep(3000);
     	
     	//switching back to the parent window
     	driver.switchTo().window(homePage);
     	
		//Clicking on the second course
		WebElement secondCourse=driver.findElement(By.xpath("(//h2[@class='color-primary-text card-title headline-1-text'])[2]"));
		secondCourse.click();
        String secondTab=driver.getWindowHandle();                  
        Set<String> windoidss = driver.getWindowHandles(); 		
   		Iterator<String> iteration1 = windoidss.iterator();
   		homePage = iteration1.next();
   		secondTab = iteration1.next();
   		
   	    driver.switchTo().window(secondTab); //switching the tab to the second course and pass the driver   
        Thread.sleep(5000);
        
        //Putting it into the Mobile view for better Clarification
   		Dimension dimn = new Dimension(1051,806); //Setting the window size
   		driver.manage().window().setSize(dimn);
        js.executeScript("window.scrollBy(0,800)");
        Thread.sleep(3000);
        String durationOf2=driver.findElement(By.xpath("//div[@class='ProductGlance _9cam1z p-t-2']//span[contains(text(),'Approx. 25 hours to complete')]")).getText();
        System.out.println("Duration of 2nd Course :  || " + durationOf2);
        driver.manage().window().maximize(); //Maximizing the window
        driver.close(); //Closing the Tab
        
        
        driver.switchTo().window(homePage);
        Thread.sleep(2000);
        //driver.quit();

	}

}