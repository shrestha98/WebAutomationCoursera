/**
 * This program is to extract all the languages and different levels from the given website with its total count
 *  and display them.
 *  @author Plugin Immortals
 *  @since 2020-05-21
 */
package cts.automation.courseraWebAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalCount 
{

	static WebDriver driver;
	
	public TotalCount(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void totalCountOfCourses() throws InterruptedException 
	{
		//System.setProperty("webdriver.chrome.driver", "C:/Users/asus/Desktop/Major Project/courseraWebDevelopment/driver/chromedriver.exe");
		//driver = new ChromeDriver();
		
		//System.out.println("1st Objective Complete");
		//Searching for the Web Development in the search textbox
		//String URL="https://www.coursera.org/search?query=web%20development&";
		//driver.navigate().to(URL);
		//driver.navigate().back();
		//String HomePage=driver.getWindowHandle();
		//driver.switchTo().window(HomePage);
		
		//driver.navigate().back();
		
		driver.get("https://www.coursera.org/search?query=web%20development&");	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Resizing the windows ( mobile view ) to get better view and clarification
		Dimension dimension = new Dimension(900,806);
		driver.manage().window().setSize(dimension);
		Thread.sleep(2000);
		
		//Pressing the filter button
		driver.findElement(By.xpath("//button[@id='toggle_filters_button_button']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@class='filter-name' and contains(text(),'Language')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='ais-RefinementList-showMore' and contains(text(),'Show more')]")).click();
		
		//Retrieving all the languages from the filter
		List<WebElement> Languages = driver.findElements(By.xpath("//*[@id=\"rendered-content\"]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/div/div[2]/div[2]/ul/div[1]/li/div[2]/div/div/div/ul"));
        System.out.println(Languages.size());
        for (WebElement webElement : Languages) 
        {
            String languageName = webElement.getText();
            System.out.println(languageName);
        }             
        Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@class='filter-name' and contains(text(),'Language')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@class='filter-name' and contains(text(),'Level')]")).click();
		
		////Retrieving all the levels from the filter
		List<WebElement> Levels = driver.findElements(By.xpath("//*[@id=\"rendered-content\"]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/div/div[2]/div[2]/ul/div[2]/li/div[2]"));
        System.out.println(Levels.size());
        for (WebElement webElement : Levels) 
        {
            String LevelName = webElement.getText();
            System.out.println(LevelName);
        }

        Thread.sleep(2000);
        //driver.quit();
        String homePage = driver.getWindowHandle();
        driver.switchTo().window(homePage);
        
        Dimension dimn = new Dimension(1051,806); //Setting the window size
   		driver.manage().window().setSize(dimn);
   		driver.manage().window().maximize();
   		//driver.quit();
	}


}
