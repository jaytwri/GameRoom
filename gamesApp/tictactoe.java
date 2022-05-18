package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class tictactoe
{
	static WebDriver driver;
	
	//Where my stuff is
	static String pathChromeDriver = "C:\\Users\\jimmy\\Desktop\\COM S\\seleniumWebDriver\\chromedriver.exe";
	static String pathValidatePage = "C:\\Users\\jimmy\\Desktop\\COM S\\Project319\\tictactoe.html";
	
	//Info to be inputed
	
	String FinalResult = "labelNotifytxtFinalResult";
	String b1 = "b1";
	String b2 = "b2";
	String b3 = "b3";
	String b4 = "b4";
	String b5 = "b5";
	String b6 = "b6";
	String b7 = "b7";
	String b8 = "b8";
	String b9 = "b9";
	
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
	public void XwinCheck() throws InterruptedException
	{
		//Open the page
		driver.get(pathValidatePage);
		driver.manage().window().maximize();
		
		//Inserting right inputs
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b1+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b7+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b3+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b2+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b9+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b6+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b5+"']")).click();
		
		//Results
		String strMessage = driver.findElement(By.xpath("//label[@id='"+FinalResult+"']")).getText();
		assertEquals("Failed test case", strMessage, "OK");
		Thread.sleep(1000);
	}

	@Test
	public void OwinCheck() throws InterruptedException
	{
		//Open the page
		driver.get(pathValidatePage);
		driver.manage().window().maximize();
		
		//Inserting right inputs
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b5+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b1+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b6+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b7+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b8+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b3+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b9+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b2+"']")).click();
		
		//Results
		String strMessage = driver.findElement(By.xpath("//label[@id='"+FinalResult+"']")).getText();
		assertEquals("Failed test case", strMessage, "OK");
		Thread.sleep(1000);
	}
	
	@Test
	public void TieCheck() throws InterruptedException
	{
		//Open the page
		driver.get(pathValidatePage);
		driver.manage().window().maximize();
		
		//Inserting right inputs
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b1+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b5+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b7+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b4+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b6+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b3+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b8+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b9+"']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='"+b2+"']")).click();
		
		//Results
		String strMessage = driver.findElement(By.xpath("//label[@id='"+FinalResult+"']")).getText();
		assertEquals("Failed test case", strMessage, "OK");
		Thread.sleep(1000);
	}
}
