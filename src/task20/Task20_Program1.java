package task20;

	
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class Task20_Program1 {
	    public static void main(String[] args) throws Exception {
	    	// Setup WebDriverManager to manage the ChromeDriver
	        WebDriverManager.chromedriver().setup();
	        
	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver();

	            // Maximize the browser window
	            driver.manage().window().maximize();

	            // Navigate to the datepicker URL
	            driver.get("https://jqueryui.com/datepicker/");
	            
	            Thread.sleep(2000);
	            // Switch to the frame 
	            driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	            Thread.sleep(2000);
	            // Open  datepicker
	            WebElement datePick= driver.findElement(By.id("datepicker"));
	            datePick.click();
	            
	            // Select the  month
	            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();

	            // Select the date 
	            WebElement date = driver.findElement(By.xpath("//a[text()='22']"));
	            date.click();

	            // Print 
	            String selectedDate = datePick.getAttribute("value");
	            System.out.println("SelectedDate: " + selectedDate);

	            // Close 
	            driver.quit();
	        }
   }

