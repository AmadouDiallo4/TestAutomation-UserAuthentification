package auth;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserRegister {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//1 launch browser
		driver.get("http://automationexercise.com/");
		driver.manage().window().maximize();
		
		// 2 test 
		String expectedTitle = "Automation Exercise";
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("###### Test Passed ###");
		}
		else {
			System.out.println("##### Test Failed ###");
		}
		
		if(driver.findElement(By.xpath("//p[@class='fc-button-label']")).isDisplayed())
		{
			driver.findElement(By.xpath("//p[@class='fc-button-label']")).click();
		}
		
		// 3 Click on 'Signup / Login' button
		driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
		
		// 4 Verify 'New User Signup!' is visible
		String signUp = driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).getText();
		if(signUp.contentEquals("New User Signup!")) {
			System.out.println("##### Test passed continue ....");
		}
		else {
			System.out.println("#### Test failed stop ...");
		}
		
		
		// 5. Enter name and email address
		WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		name.clear();
		name.sendKeys("amadou");
		WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
		email.clear();
		email.sendKeys("amadou@gmail.com");
				
		// 6. Click 'Signup' button
		driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
		
		// 7 Verify that 'ENTER ACCOUNT INFORMATION' is visible
		String accountInfo = driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']")).getText();
		if(accountInfo.equalsIgnoreCase("Enter Account Information")) {
			System.out.println("#### Account information is displayed ##");
		}
		else {
			System.out.println("### Account information not correct ##");
		}
	}

}
