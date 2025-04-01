package airline;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testclass {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
    	 String rootDir = System.getProperty("user.dir");
         String chromeDriverPath = rootDir + "\\chromedriver.exe";
         System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testNavigationItems() throws Exception {
       driver.get("https://www.airnavradar.com/@17.38410,78.45640,z6");
        
       
        driver.findElement(By.xpath("//p[text()='Consent']/..")).click();
        
            Thread.sleep(2000);
        

       
        List<WebElement> topNavItems = driver.findElements(By.xpath("//nav/ul/li//li[contains(@class,'NavigationMenuListItem ')]/a"));
        System.out.println(topNavItems);
        
        for(WebElement e:topNavItems) {
        	String url= e.getAttribute("href");
        	
        	URL link = new URL(url); 
        	HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection(); 
        	httpURLConnection.connect();
        			if(e.getAttribute("href").contains("contactus")) { 
        			  if (httpURLConnection.getResponseCode() == 200  ) 
        			  { 
        				  System.out.println(url + " - " + httpURLConnection.getResponseMessage()); 
        			  } 
        			  else {
        				  System.out.println(url + " - " + httpURLConnection.getResponseMessage() +" - " + "is a broken link"); 
        			  } 
        			  
        			}
        }
      
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
