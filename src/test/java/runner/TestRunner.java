package runner;


import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.*;
import pages.BasePage;


	@RunWith(Cucumber.class)
	
	@CucumberOptions( //Todas las opciones de cucumber se enlistan en esta seccion
		features = "src/test/resources/features", //Directorio de ubicacion de los archivos tipo feature
		glue = "steps", //Directorio de la carpeta steps
		monochrome = true,
		tags = "@List", //Que tags de esenarios se ejecutaran
		plugin = {
					"pretty",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"json:target/cucumber-reports.json"
				}
	)
	
	
	public class TestRunner{
		
		//Despues de cada ejecucion de el browser se cerrara - AFTER CLASS
		@AfterClass
		public static void closeDiver() {
			BasePage.quitDriver();
		}
	}