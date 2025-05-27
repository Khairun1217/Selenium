package task9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Guvisignup {
    public static void main(String[] args) {
      
        String name = "Khairun";
        String email = "khairunkhairun609@gmail.com";
        String password = "Sulaiha@123";
        String mobile = "9876543210"; // dummy number
        
       
        WebDriver driver = new ChromeDriver();
        
      
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
        try {
           
            driver.get("https://www.guvi.in/");
            System.out.println("Launched GUVI.in successfully");
            
          
            WebElement signupButton = driver.findElement(By.xpath("//a[contains(text(),'Sign up')]"));
            signupButton.click();
            System.out.println("Clicked on Signup button");
            
         
            driver.findElement(By.id("name")).sendKeys(name);
            driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("mobileNumber")).sendKeys(mobile);
            System.out.println("Filled signup form");
            
           
            driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")).click();
            System.out.println("Submitted signup form");
            
           
            if (driver.getCurrentUrl().contains("account") || 
                driver.getTitle().toLowerCase().contains("dashboard")) {
                System.out.println("Registration successful");
            } else {
                System.out.println("Registration verification failed");
            }
            
            
            WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
            loginButton.click();
            System.out.println("Clicked on Login button");
            
            driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.id("password")).sendKeys(password);
            System.out.println("Filled login form");
            
            
            driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
            System.out.println("Submitted login form");
            
            
            if (driver.getCurrentUrl().contains("account") || 
                driver.getTitle().toLowerCase().contains("dashboard")) {
                System.out.println("Login successful");
                System.out.println("Current page title: " + driver.getTitle());
            } else {
                System.out.println("Login verification failed");
            }
            
            
            Thread.sleep(3000);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            driver.quit();
            System.out.println("Browser closed");
        }
    }
}