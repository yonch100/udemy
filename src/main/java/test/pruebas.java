package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String searchTextField = "//textarea[@name='q']";
		String searchButton = "//input[@value='Buscar con Google']"; 
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\usuario1\\Documents\\javaProject\\udemyJava1\\udemyjava2\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		
		WebElement campo = driver.findElement(By.xpath(searchTextField) );
		campo.sendKeys("mexico");
		
		WebElement boton = driver.findElement(By.xpath(searchButton) );
		boton.click();
		
		driver.close();
		
		
		
	}
}