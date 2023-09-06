package steps;

import org.junit.Assert;
import io.cucumber.java.en.*;
import pages.GooglePage;

public class GoogleSteps {
	
	GooglePage google = new GooglePage();
	
	
	
	/**
	 * Abre el explorador y se muestra la pagina de google
	 */
	@Given("^Enter on a google search page$")
	public void navigateToGoogle() {	
		google.navigateToGoogle();
	}
	
	
	
	/**
	 * Se ingresa un valor en el campo de busqueda de google
	 */
	@When("^Type search criteria$")
	public void enterSearchCriteria() {
		//en el metodo enterSearchCriteria no es necesario pasasrlo por parametro
		google.enterSearchCriteria("Mexico"); 
	}
	
	
	
	/**
	 * Da clic en el boton buscar
	 */
	@And("^Click on the search button$")
	public void clickSearchButton() {
		google.clickButtonSearch();
	}
	
	
	
	/**
	 * Se muestran los resultados en la pagina
	 */
	@Then("^The results match the criteria$")
	public void validateResults() {
		Assert.assertEquals("Text que esperamos", google.firstResult() );
	} 
	
}
