package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	//contar con un navgador abierto
	protected static WebDriver driver; //1 sola intancia para
	private static WebDriverWait wait;
	private static Actions actions;
	
	
	/**
	 * Objeto estatico para el webdriver y para el wait
	 */
	static{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\usuario1\\Documents\\javaProject\\udemyJava1\\udemyjava2\\webdrivers\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new ChromeDriver(chromeOptions);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //objeto de webdriver-tiempo de espera
	}
	
	
	
	/**
	 * Bloque estatico donde se esta creando el driver solo una vez para todas las instancias que se creen
	 * a partir de esta y se use en las demas paginas. cuenta con una espera de 10 seg,
	 * 
	 * @param driver
	 */
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	
	
	/**
	 * Se crea la instancia de driver que nos ayudara a inicializar el navegador
	 * @param url
	 */
	public static void navigateTo(String url) {
		driver.get(url);
	}
	
	
	
	/**
	 * 
	 * @param element
	 * @return
	 */
	private WebElement findElement(String element) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element) ));
	}
	
	
	
	/**
	 * Metodo para dar clic en un webelement
	 * 
	 * @param element
	 */
	public void clickElement(String element) {
		findElement(element).click();
	}
	
	
	
	/**
	 * Metodo para agregar texto en un campo textbox
	 * 
	 * @param element
	 */
	public void write(String element, String textToWrite) {
		findElement(element).clear();
		findElement(element).sendKeys(textToWrite);
	}
	
	
	
	/**
	 * funcion para realizar la seleccion de un dropdown - por medio de lo que muestra el dropdonw
	 * 
	 * @param element
	 * @param valueToSelect
	 */
	public void selectDropdownByValue(String element, String valueToSelect) {
		Select dropdown = new Select(findElement(element) );
		dropdown.selectByValue(valueToSelect);
		
	}
	
	
	
	/**
	 * funcion para realizar la seleccion de un dropdown - Por medio del index
	 * 
	 * @param element
	 * @param valueToSelect
	 */
	public void selectDropdownByIndex(String element, int indexToSelect) {
		Select dropdown = new Select(findElement(element) );
		dropdown.selectByIndex(indexToSelect);
		
	}
	
	
	
	/**
	 * funcion para realizar la seleccion de un dropdown - Por medio del index
	 * 
	 * @param element
	 * @param valueToSelect
	 */
	public void selectDropdownByText(String element, String valueToSelect) {
		Select dropdown = new Select(findElement(element) );
		dropdown.selectByVisibleText(valueToSelect);
		
	}
	
	
	
	/**
	 * Accion para pasar el cursor sobre un elemento - Hover over con el mouse
	 * 
	 * @param element
	 */
	public void hoverOverElement(String element) {
		actions.moveToElement(findElement(element) );
	}
	
	
	
	/**
	 * Doble clic con el mouse
	 * 
	 * @param element
	 */
	public void doubleClick(String element) {
		actions.doubleClick(findElement(element) );
	}
	
	
	
	/**
	 * clic con el boton derecho del mouse
	 * 
	 * @param element
	 */
	public void rightClick(String element) {
		actions.contextClick(findElement(element) );
	}
	
	
	
	/**
	 * Metodo para obtener un valor de una tabla en una posicion x/y
	 * 
	 * @param element
	 * @param row
	 * @param column
	 * @return
	 */
	public String getValueFromTable(String element, int row, int column) {
		String cellINeed = element + "/table/tbody/tr[" + row + "]/td[" + column + "]";
		
		return findElement(cellINeed).getText();
	}
	
	
	
	/**
	 * Metodo para agregar un valor en  una tabla en una posicion x/y
	 * 
	 * @param element
	 * @param row
	 * @param column
	 * @param stringToSend
	 */
	public void setValueFromTable(String element, int row, int column, String stringToSend) {
		String cellToFill = element + "/table/tbody/tr[" + row + "]/td[" + column + "]";
		findElement(cellToFill).sendKeys(stringToSend);
	}
	
	
	
	public void switchToIFrame(int iFrameIndex) {
		driver.switchTo().frame(iFrameIndex);
	}
	
	
	
	public void switchToParentFame() {
		driver.switchTo().parentFrame();
	}


	
	/**
	 * Detecta si encuentra una alerta y la elimina, continua con las siguientes acciones
	 */
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	
	/**
	 * Obtener un texto de un element
	 * 
	 * @param element
	 * @return
	 */
	public String textFromElement(String element) {
		return findElement(element).getText();
	}
	
	
	/**
	 * 
	 * @param element
	 * @return
	 */
	public boolean elementEnabled(String element) {
		return findElement(element).isEnabled();
	}
	
	
	
	/**
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean elementIsDisplayed(String element) {
		return findElement(element).isDisplayed();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public boolean elementIsSelected(String element){
		return findElement(element).isSelected();
	}
	
	
	/**
	 * 
	 * @param element
	 * @return Every element in list
	 */
	public List<WebElement> bringMeAllElements(String element){
		return driver.findElements(By.className(element) );
	}
	
	
	/**
	 * Metodo para realizar el cierre del driver
	 */
	public void closeDriver() {
		driver.close();
	}
	
	/**
	 * Metodo para realizar el cierre del driver
	 */
	public static void quitDriver() {
		driver.quit();
	}
	
}
