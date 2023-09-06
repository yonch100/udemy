package pages;


import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;


public class ListPage extends BasePage{
    
	public ListPage() {
        super(driver);
	}
	
	
    private String searchField = "//body/div[1]/div[1]/div[1]/span[1]/input[2]";
    private String searchResults = "tt-suggestion";
 
 
    public void navigateToListPage() {
        //navigateTo("https://andreidbr.github.io/J530/064jaxTypeAhead/index.html");
    	navigateTo("https://twitter.github.io/typeahead.js/examples/");
    }
 
    public void enterSearchCriteria(String state) throws InterruptedException {
        Thread.sleep(1000);
        write(searchField, state);
    }
 
    public List<String> getAllSearchResults() {
        List<WebElement> list = bringMeAllElements(searchResults);
        List<String> stringFromList = new ArrayList<String>();
        
        for (WebElement e : list) {
            stringFromList.add(e.getText());
        }
        
        return stringFromList;
    }

	
    

}
