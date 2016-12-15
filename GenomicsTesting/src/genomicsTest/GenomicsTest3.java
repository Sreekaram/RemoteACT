package genomicsTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GenomicsTest3 {
	public class GenomicsLoginTest {
		public WebDriver driver;
	    private String baseUrl;

	    @BeforeSuite
	    public void setUp() throws Exception {
	    	//driver = new FirefoxDriver();
	    	System. setProperty("webdriver.chrome.driver", "C:/Drivers//chromedriver.exe");
	        driver = new ChromeDriver();
	       baseUrl = "https://cln-test-damsauto.gel.zone/labkey/";
	       driver.navigate().to(baseUrl);
	       driver.manage().window().maximize();   
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          
	    }

	    /*@AfterSuite
	    public void tearDown() throws Exception {
	       driver.quit();    
	    }*/
	    @Test
	    public void testGenomicsLogin() throws InterruptedException{
	    	//Click on Singin	
	    	driver.findElement(By.className("labkey-nomenu-text-link")).click();
	    	Thread.sleep(2000);
	    	WebElement user=driver.findElement(By.id("email"));
	    	user.sendKeys("Santhosh.s@stagsoftware.com");
	    	WebElement pwd=driver.findElement(By.id("password"));
	    	pwd.sendKeys("santhu1974");
	    	driver.findElement(By.xpath("//a[@class='labkey-button signin-btn']/span")).click();
	    	Thread.sleep(2000);
	    	System.out.println("Title is " + driver.getTitle());
	    	Assert.assertEquals("DAMS AUTO LabKey Server", driver.getTitle());
	}
	    @Test(priority=1)
	    public void testGenomicsHomePage() throws InterruptedException{
	       // Click on Mercury
	    	Thread.sleep(10000);
	        driver.findElement(By.xpath("//li[@id='projectBar']")).click();
	    	Thread.sleep(10000);
	        driver.findElement(By.xpath("//div[@id='projectBar_menu']//a[text()='MeRCURy']")).click();
	     // Click on Rare Diseases
	        driver.findElement(By.linkText("Rare Diseases")).click();
	       Thread.sleep(2000);
	     // Click on v.13 Rare Diseases
	        driver.findElement(By.linkText("V1.3 Pedigree")).click();
	        //Click on Participant id
	        driver.findElement(By.xpath("//td[@title='participant_id']")).click();
	        Thread.sleep(5000);
	      //Click on filter
	        driver.findElement(By.xpath("//span[@id='menuitem-1133-textEl']")).click();
	        Thread.sleep(5000);
	        //Enter Filter Type
	        driver.findElement(By.xpath("//input[@id='value_1']")).sendKeys("800000981");
	        //Clcik on Ok
	        driver.findElement(By.xpath("//td[@class='x-btn-mc']//button")).click();
	      //Clcik on Participant id
	        Thread.sleep(10000);
		    driver.findElement(By.linkText("800000981")).click();
	        Thread.sleep(10000);
	        WebElement image3 =driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='rect' and @x='644' and @y='504' and @class='pedigree-node-shadow' and @fill='#808080'][1]"));
 	        Actions builder2 = new Actions(driver);
 	        builder2.moveToElement(image3).click(image3);
 	        builder2.perform();
 	        Thread.sleep(10000);
 	       //close popup
 		     driver.findElement(By.xpath("//div[@class='menu-box']//span[@class='close-button']")).click();
 		      WebElement element =driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='circle'  and @cy='272' and @cx='300' and @fill='#808080' and @opacity='0.3'][1]"));
 		      Actions builder = new Actions(driver);
 		       Thread.sleep(10000);
 			   builder.moveToElement(element).click(element);
 		       builder.perform();
}
	}
}

