package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;




public class jse
{
	WebDriver driver;
	@Test
	public void jsee() throws InterruptedException
	{
		 driver = new FirefoxDriver();
		driver.get("http://spicejet.com");
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_IndArm']/label"));
		drawborder(driver,element);
		Thread.sleep(1000);
		refreshbrowser();
		String message="alert is displayed";
		runtimealert(driver,message);
		driver.switchTo().alert().accept();
		WebElement element1 = driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_chk_friendsandfamily']"));
		clickelement(element1);
		String top=title(driver);
		System.out.println("Title of the page is "+top);
		//String psfull=fullpagesource(driver);
		//System.out.println(fullpagesource(driver));
		/*String date = "30/09";
		WebElement element3=driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_view_date1']"));
		datecall(driver,date,element3);*/
		
		driver.get("https://www.abhibus.com/");
		String date = "28-04-2018";
		WebElement element3 =driver.findElement(By.xpath(".//*[@id='datepicker1']"));
		datecall(driver,date,element3);
		scrolldown(driver);
		
		
	}

	
	
	public  void drawborder(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jsi = (JavascriptExecutor)driver;
		jsi.executeScript("arguments[0].style.border='3px solid red'",element);
		
	}
	public void runtimealert(WebDriver driver,String message)
	{
		JavascriptExecutor jsi = (JavascriptExecutor)driver;
		jsi.executeScript("alert('"+message+"')");
		
	}
	public void refreshbrowser()
	{
		JavascriptExecutor jsi = (JavascriptExecutor)driver;
		jsi.executeScript("history.go(0)");
	}
	public void clickelement(WebElement element1)
	{
		JavascriptExecutor jsi = (JavascriptExecutor)driver;
		jsi.executeScript("arguments[0].click();",element1);
	}
	public String title(WebDriver driver) 
	{
		JavascriptExecutor jsi = (JavascriptExecutor)driver;
		String title = jsi.executeScript("return document.title;").toString();
		return title;
	}
	/*public String fullpagesource(WebDriver driver)
	{
		JavascriptExecutor jsi = (JavascriptExecutor)driver;
		String ps=jsi.executeScript("return document.documentElement.innerText;").toString();
		return ps ;
	}*/
	public void datecall(WebDriver driver,String date,WebElement element3)
	{
		JavascriptExecutor jsi = (JavascriptExecutor)driver;
		jsi.executeScript("arguments[0].setAttribute('value','"+date+"');",element3);
	}
	//scrolldown
	public void scrolldown(WebDriver driver)
	{
		JavascriptExecutor jsi = (JavascriptExecutor)driver;
		jsi.executeScript("window.scrollTo(0,document .body.scrollHeight)");
	}
}
		