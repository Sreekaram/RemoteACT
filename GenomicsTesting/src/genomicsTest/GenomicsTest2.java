package genomicsTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GenomicsTest2 {
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
//System.out.println("Title is Anil");
	  //System.out.println("Title is Anil");
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
	        Thread.sleep(10000);
	        //Enter Filter Type
	        driver.findElement(By.xpath("//input[@id='value_1']")).sendKeys("800000981");
	        //Clcik on Ok
	        driver.findElement(By.xpath("//td[@class='x-btn-mc']//button")).click();
	      //Clcik on Participant id
	        Thread.sleep(10000);
		    driver.findElement(By.linkText("800000981")).click();
	        Thread.sleep(10000);
	    
	    }
	    public void clickOnRect(String Element){
	    	WebElement text=driver.findElement(By.xpath("//*[name()='text']"));
	    	String iamgetesxt=text.getAttribute("x");
	    	
	    	
	    	//String Y=text.getAttribute("Y");
	
	    	
	    	String rect=driver.findElement(By.xpath("//*[name()='rect' and @class='pedigree-node-shadow']")).getAttribute("x");
	    	
	    	
	    	
	    	WebElement rectclick=driver.findElement(By.xpath("//*[name()='rect' and @class='pedigree-node-shadow' and @x='image]"));
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	   /*     // Locate text and save in the WebElement instances.
	  
	  List<WebElement>rectxyvalue=driver.findElements(By.xpath("//*[name()='rect']"));
	  
	  for(WebElement r:rectxyvalue){
		  System.out.println("rect X value is:- " +r.getAttribute("x"));
		  System.out.println("rect y value is:- " +r.getAttribute("y"));
	  }
	  
	  
	    List<WebElement>textxyvalue=driver.findElements(By.xpath("//*[name()='text']"));
		  
		  for(WebElement t:textxyvalue){
			  System.out.println("text X value is:- " +t.getAttribute("x"));
			  System.out.println("text y value is:- " +t.getAttribute("y"));
		  }
		  List<WebElement>text=driver.findElements(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='text']//*[name()='tspan']"));
	        for(WebElement t:text){
	        	  System.out.println("Name is " + t.getText());
	        	  if(t.getText().equals("RDPBMULTI1_4_FN RDPBMULTI1_4_SN")){
	        		  //select it
	        		  WebElement rect=driver.findElement(By.xpath("//*[name()='rect' and @class='pedigree-node-shadow']"));
	        		     System.out.println("rect X value is:- " +rect.getAttribute("x"));
	        		     if(rect.getAttribute("x").equals("644")){
	        		    	 Actions builder2 = new Actions(driver);
	        	  	        builder2.moveToElement(rect).click(rect);
	        	  	        builder2.perform();
	        	  } else
	        		  System.out.println("test is not matched");
	    
		    }
	        	  }
	    
	  String textyvalue=driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='text']//*[name()='tspan']")).getAttribute("y");
	  String rectxvalue=driver.findElement(By.xpath("//*[name()='rect' and @class='pedigree-hoverbox']")).getAttribute("x");
	  String rectyvalue=driver.findElement(By.xpath("//*[name()='rect' and @class='pedigree-hoverbox']")).getAttribute("y");
	  
	  WebElement textxpath1=driver.findElement(By.xpath("//*[name()='text' and @x='684' and @y='616']//*[name()='tspan']"));
	   WebElement textxpath2=driver.findElement(By.xpath("//*[name()='text' and @x='444' and @y='72']//*[name()='tspan']"));     
	   WebElement textxpath3=driver.findElement(By.xpath("//*[name()='text' and @x='300' and @y='344']//*[name()='tspan']"));
	   WebElement textxpath4=driver.findElement(By.xpath("//*[name()='text' and @x='60' and @y='344']//*[name()='tspan']"));
	   WebElement textxpath5=driver.findElement(By.xpath("//*[name()='text' and @x='1068' and @y='344']//*[name()='tspan']"));
	   WebElement recxpath=driver.findElement(By.xpath("//*[name()='text' and @x='1068' and @y='344']//*[name()='tspan']"));
	   public void pedigreeTest(String textxpath1, String recxpath){
	        
	        }
	       
	       
	           try {
	        	   
	        	   WebElement image3 =driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='rect' and @x='644' and @y='504' and @class='pedigree-node-shadow' and @fill='#808080'][1]"));
	            	Actions builder2 = new Actions(driver);
	     	        builder2.moveToElement(image3).click(image3);
	     	        builder2.perform();
	     	       
	            } catch (WebDriverException e) {
	                System.out.println("Exception  " + e);
	                
	               try {
	 	        	   
	 	        	   WebElement image3 =driver.findElement(By.xpath("//*[name()='rect' and @x='644' and @y='504'][3]"));
	 	            	Actions builder2 = new Actions(driver);
	 	     	        builder2.moveToElement(image3).click(image3);
	 	     	        builder2.perform();
	 	     	       
	 	            } catch (WebDriverException e1) {
	 	                System.out.println("Exception  " + e1);
	 	            }
	                
	        
	               driver.findElement(By.xpath("//div[@class='menu-box']//span[@class='close-button']")).click();
		   		      
	                try {
	 	        	   
	                	WebElement element =driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='circle'  and @cy='272' and @cx='300' and @fill='#808080' and @opacity='0.3'][1]"));
	  	   		      Actions builder = new Actions(driver);
	  	   		       Thread.sleep(10000);
	  	   			   builder.moveToElement(element).click(element);
	  	   		       builder.perform();
	 	            } catch (WebDriverException c) {
	 	                System.out.println("Exception  " + c);
	 	              
	 	                
	 	                try {
		 	        	   
		 	        	   WebElement image3 =driver.findElement(By.xpath("//*[name()='rect' and @x='644' and @y='504'][3]"));
		 	            	Actions builder2 = new Actions(driver);
		 	     	        builder2.moveToElement(image3).click(image3);
		 	     	        builder2.perform();
		 	     	       
		 	            } catch (WebDriverException e1) {
		 	                System.out.println("Exception  " + e1);
		 	          }
	        
	        
	        
	        
	        //Click Pedigree Editor
	        //WebElement image3 =driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='text' and @x='684'][1] and //*[name()='rect' and @x='644' and @y='504' and @class='pedigree-node-shadow' and @fill='#808080'][1]"));
	       
	        //WebElement image3 =driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='rect' and @x='644' and @y='504' and @class='pedigree-node-shadow' and @fill='#808080'][1]"));
 	        Actions builder2 = new Actions(driver);
 	        builder2.moveToElement(image3).click(image3);
 	        builder2.perform();
 	        Thread.sleep(10000);
 	      //Close  Popup
 	    
 	       driver.findElement(By.xpath("//div[@class='menu-box']//span[@class='close-button']")).click();
 	     //Click Pedigree Editor
 	        WebElement element =driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='circle'  and @cy='272' and @cx='300' and @fill='#808080' and @opacity='0.3'][1]"));
 	        Actions builder = new Actions(driver);
 	        Thread.sleep(10000);
 		    builder.moveToElement(element).click(element);
 	        builder.perform();
	        
	       
	       WebElement image3 =driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='rect' and @x='644' and @y='504' and @transform='matrix(1.08,0,0,1.08,-54.72,-43.52)'][1]"));
	        boolean clicked = false;
	        do{
	            try {
	            	Actions builder2 = new Actions(driver);
	     	        builder2.moveToElement(image3).click(image3);
	     	        builder2.perform();
	            } catch (WebDriverException e) {
	                System.out.println("Exception  " + e);
	            } finally {
	                clicked = true;
	            }
	        } while (!clicked);
	       // Fecthing all the text
	        
	        
	        List<WebElement>text=driver.findElements(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='text']//*[name()='tspan']"));
	        for(WebElement t:text){
	        	  System.out.println("Name is " + t.getText());
	        	  //if(t.getText().equals("RDPBMULTI1_FN RDPBMULTI1_SN ")){
	        		  //select it
	        	
	        		  
	        		
	        	}
	        		  
	        
	        WebElement image3 =driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='rect' and @x='644' and @y='504' and @class='pedigree-node-shadow' and @fill='#808080'][1]"));
   	        Actions builder2 = new Actions(driver);
   	        builder2.moveToElement(image3).click(image3);
   	        builder2.perform();
   	        Thread.sleep(10000);
	       
	        
	        //WebElement UAT=driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='text'][3]/*[name()='tspan']"));
	       /* WebElement rdp9841=driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='text'][1]"));
	        WebElement rdp9833=driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='text'][4]"));
	        WebElement rdp9825=driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='text'][7]"));
	        WebElement rdp9817=driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='text'][10]"));
	        System.out.println("Name is " +  UAT.getText());
	        Thread.sleep(10000);
	        WebElement image3 =driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='rect' and @class='pedigree-node-shadow' and @x='164']"));
 	        Actions builder2 = new Actions(driver);
 	        builder2.moveToElement(image3).click(image3);
 	        builder2.perform();
	        if(UAT.equals("UAT TEST123 UAT TEST123")){
	        	Thread.sleep(10000);
		        WebElement image3 =driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='rect' and @class='pedigree-node-shadow' and @x='164']"));
	 	        Actions builder2 = new Actions(driver);
	 	        builder2.moveToElement(image3).click(image3);
	 	        builder2.perform();
 	       
	       
	        }
	       
	        	
	      // Thread.sleep(10000);
	      //close popup
	     /* driver.findElement(By.xpath("//div[@class='menu-box']//span[@class='close-button']")).click();
	      WebElement element =driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='circle'  and @cy='272' and @cx='300' and @fill='#808080' and @opacity='0.3'][1]"));
	      Actions builder = new Actions(driver);
	        Thread.sleep(10000);
		    builder.moveToElement(element).click(element);
	        builder.perform();
	      //close popup
	        //driver.findElement(By.xpath("//div[@class='menu-box']//span[@class='close-button']")).click();
		       //Thread.sleep(20000);
		        WebElement image3 =driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='rect' and @class='pedigree-node-shadow' and @x='644' and @y='504']"));
		        Actions builder2 = new Actions(driver);
		        builder2.moveToElement(image3).click(image3);
		        
		        
 	     //WebElement image3 =driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='rect' and @x='644' and @y='504' and @class='pedigree-node-shadow' and @fill='#808080'][1]")); 
	        
	        String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
	          
	        // Execute the Java Script for the element which we find out
	        ((JavascriptExecutor) driver).executeScript(js, image3);
	         
	        // Click on element
	         
	        image3.click();

	        JavascriptExecutor executor = (JavascriptExecutor) driver;
	        executor.executeScript("arguments[0].click();", image3);
	        
	      //close popup
	     // driver.findElement(By.xpath("//div[@class='menu-box']//span[@class='close-button']")).click();
	       // Thread.sleep(10000);
	        WebElement element1 =driver.findElement(By.xpath("//div[@id='canvas']//*[name()='svg']//*[name()='path' and @d='M828,272L773,272']"));
	        Actions builder1 = new Actions(driver);
	        builder1.moveToElement(element1).click(element1);
	      */
 	       
 	        
 	        
 	        
 	        
 	        
 	        
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	}	  
	    
	   
	

