package  pages;

public class GooglePage extends BasePage{
	
	private String searchTextField = "//textarea[@name='q']";
	private String searchButton = "//input[@value='Buscar con Google']";
	private String firstResult = "";
	
	public GooglePage() {
		super(driver);
	}
	
	public void navigateToGoogle() {
		navigateTo("http://www.google.com");
	}
	
	public void enterSearchCriteria(String criteria) {
		write(searchTextField, criteria);
	}
	
	public void clickButtonSearch() {
		clickElement(searchButton);
	}
	
	public String firstResult() {
		return textFromElement(firstResult);
	}

}
