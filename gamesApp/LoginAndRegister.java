package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginAndRegister 
{
	static WebDriver driver;
	static Select gender;
	static Select state;
	
	//Where my stuff is
	static String pathChromeDriver = "C:\\Users\\jimmy\\Desktop\\COM S\\seleniumWebDriver\\chromedriver.exe";
	static String pathValidateLogin = "C:\\Users\\jimmy\\Desktop\\COM S\\Project319\\gamesapp-master\\gamesApp\\views\\login.html";
	static String pathValidateRegister = "C:\\Users\\jimmy\\Desktop\\COM S\\Project319\\gamesapp-master\\gamesApp\\views\\register.html";
	
	//Info to be inputed
	String txtUsername = "txtUsername";
	String txtPassword = "txtPassword";
	String txtPasswordCheck = "txtPasswordCheck";
	String linkValidate = "linkValidate";
	String FinalResult = "labelNotifytxtFinalResult";
	
	@BeforeClass
	public static void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", pathChromeDriver);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void closeBrowser()
	{
		driver.quit();
	}
	
	@Test
	public void LoginSuccessfulInputCheck() throws InterruptedException
	{
		//Open the page
		driver.get(pathValidateLogin);
		driver.manage().window().maximize();
		
		//Inserting right inputs

		driver.findElement(By.xpath("//input[@id='"+txtUsername+"']")).sendKeys("jdriskel");
		driver.findElement(By.xpath("//input[@id='"+txtPassword+"']")).sendKeys("GameRoomBaby123");
		
		//Presses the validate button for you
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='"+linkValidate+"']")).click();
		
		//Results
		String strMessage = driver.findElement(By.xpath("//label[@id='"+FinalResult+"']")).getText();
		assertEquals("Failed test case", strMessage, "OK");
		Thread.sleep(1000);
	}
	
	@Test
	public void LoginUnsuccessfulInputCheck() throws InterruptedException
	{
		//Open the page
		driver.get(pathValidateLogin);
		driver.manage().window().maximize();
		
		//Inserting wrong inputs
		driver.findElement(By.xpath("//input[@id='"+txtUsername+"']")).sendKeys("!@#!%#@%");
		driver.findElement(By.xpath("//input[@id='"+txtPassword+"']")).sendKeys("");
		
		//Presses the validate button for you
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='"+linkValidate+"']")).click();
		
		//Results
		String strMessage = driver.findElement(By.xpath("//label[@id='"+FinalResult+"']")).getText();
		assertEquals("Failed test case", strMessage, "Error");
		Thread.sleep(2000);
	}
	
	@Test
	public void RegisterSuccessfulInputCheck() throws InterruptedException
	{
		//Open the page
		driver.get(pathValidateRegister);
		driver.manage().window().maximize();
		
		//Inserting right inputs

		driver.findElement(By.xpath("//input[@id='"+txtUsername+"']")).sendKeys("jdriskel");
		driver.findElement(By.xpath("//input[@id='"+txtPassword+"']")).sendKeys("GameRoomBaby123");
		driver.findElement(By.xpath("//input[@id='"+txtPasswordCheck+"']")).sendKeys("GameRoomBaby123");
		
		//Presses the validate button for you
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='"+linkValidate+"']")).click();
		
		//Results
		String strMessage = driver.findElement(By.xpath("//label[@id='"+FinalResult+"']")).getText();
		assertEquals("Failed test case", strMessage, "OK");
		Thread.sleep(1000);
	}
	
	@Test
	public void RegisterUnsuccessfulInputCheck() throws InterruptedException
	{
		//Open the page
		driver.get(pathValidateRegister);
		driver.manage().window().maximize();
		
		//Inserting right inputs

		driver.findElement(By.xpath("//input[@id='"+txtUsername+"']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='"+txtPassword+"']")).sendKeys("GameRoomBaby123");
		driver.findElement(By.xpath("//input[@id='"+txtPasswordCheck+"']")).sendKeys("WrongPassword");
		
		//Presses the validate button for you
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='"+linkValidate+"']")).click();
		
		//Results
		String strMessage = driver.findElement(By.xpath("//label[@id='"+FinalResult+"']")).getText();
		assertEquals("Failed test case", strMessage, "Error");
		Thread.sleep(2000);
	}
	
}
