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
        

       
        List<WebElement> topNavItems = driver.findElements(By.xpath("//nav/ul/li"));
        System.out.println(topNavItems);
        
        List<WebElement> subItemLabels = null;
        List<WebElement> subRootItemLabels = null;
        Set<String> navigationLabels = new HashSet();

       
        for (WebElement navItem : topNavItems) {
            Actions action = new Actions(driver);

            action.moveToElement(navItem).build().perform();
            System.out.println(navItem);
            Thread.sleep(500);
            WebElement topLevelLabel = navItem.findElement(By.xpath("//div[@class='ListItemLabel']/span"));
            navigationLabels.add(topLevelLabel.getText());
            subItemLabels = navItem.findElements(By.xpath("//div[@class='ListItemLabel']/span"));
            subRootItemLabels = navItem.findElements(By.xpath("//a[@class='ListItemLabel']"));
            for (WebElement subLabel : subItemLabels) {
                navigationLabels.add(subLabel.getText());
                

            }
            
            for (WebElement subRootLabel : subRootItemLabels) {
                navigationLabels.add(subRootLabel.getText());
                
            }
        }

       
        System.out.println("Navigation Labels:");
        for (String label : navigationLabels) {
            System.out.println(label);
            if(label.contains("Contact Us")) {
            	System.out.println("TC1 has passed");
            }
        }
        
        for (WebElement subLabel : subItemLabels) {
            navigationLabels.add(subLabel.getText());
            subLabel.click();
            driver.navigate().back();
            Thread.sleep(2000);

        }
        
        for (WebElement subRootLabel : subRootItemLabels) {
            navigationLabels.add(subRootLabel.getText());
            subRootLabel.click();
            driver.navigate().back();
            Thread.sleep(2000);
        }
        
      
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}