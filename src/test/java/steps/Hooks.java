package steps;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import cucumber.api.Scenario;
import pages.BasePage;

import io.cucumber.java.*;
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;

//import org.junit.*;
import org.junit.After;
//import org.junit.AfterClass;

public class Hooks extends BasePage{
	
	public Hooks() {
		super(driver);
	}
	
	@After
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed() ) {
			scenario.write("*** Scenario Fallido - Referencia en la imagen adjunta.");
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/pgn");
		}
		
		/**
		public void before_or_after(io.cucumber.java.Scenario scenario)	{
		if(scenario.isFailed() ) {
			scenario.log("*** Scenario Fallido - Referencia en la imagen adjunta.");
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image-report", ".png");
		}
		*/
		
	}
}
