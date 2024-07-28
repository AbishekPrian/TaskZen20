package task20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v124.runtime.model.ExceptionThrown;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task20_Program2 {

	public static void main(String[] args) throws Exception {

 // Setup WebDriverManager to manage the ChromeDriver
    WebDriverManager.chromedriver().setup();
    
    WebDriver driver=new ChromeDriver();

    //go to URL
    driver.get("https://www.guvi.in");

    //Maximize the browser window
    driver.manage().window().maximize();
    Thread.sleep(1000);

    //Click on SIGNUP button
    driver.findElement(By.xpath("//a[@class='bg-green-500 hover:bg-green-600 text-white font-normal py-2 px-4 rounded text-base min-h-8 h-8 align-middle mr-6']")).click();

    //Enter the full name 
    driver.findElement(By.id("name")).sendKeys("Test");


    //Enter the Email
    driver.findElement(By.id("email")).sendKeys("testuser123@gmail.com");

    //Enter the Password
    driver.findElement(By.id("password")).sendKeys("testuser123@");

    //Enter the Mobile number
    driver.findElement(By.id("mobileNumber")).sendKeys("7328996783");

    //click on sign-up
    driver.findElement(By.id("signup-btn")).click();
          Thread.sleep(2000);
          
    //Verify that the user is successfully registered 
   
    try {      
    WebElement successMessage=driver.findElement(By.xpath("//h2[@id='status_title']"));
    if (successMessage.getText().equals("Successfully Registered"))
     System.out.println("User is successfully registered");
    }
    catch (Exception e){
    
     System.out.println("User is not successfully registered");
    }
    
    driver.navigate().to("https://www.guvi.in/sign-in/");
    // Enter the Email address 
    driver.findElement(By.xpath("//input[@id='email']")). sendKeys("Testuser123@gmail.com");

    //Enter the Password 
    driver.findElement(By.id("password")).sendKeys("rohitsharma5");

    //Click on login button 
    driver.findElement(By.id("login-btn")).click();
    
    
    Thread.sleep(4000);
    //verify successful login
    WebElement feedbackElement = driver.findElement(By.className("invalid-feedback"));
    
    System.out.println(feedbackElement.getText());
    // Verify the text content of the element
    if (feedbackElement.getText().equals("Incorrect Email or Password")) {
        System.out.println("Login Failed: Enter valid credentials");
    } else if (feedbackElement.getText().equals("Oh! No profile exists with this Email ID.")) {
    
    	System.out.println("Login Failed: Enter valid credentials");
    }
 


    //Close the Browser
    driver.close();
	}
	   
	}
