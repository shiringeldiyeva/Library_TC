package com.library.step_definitions;

import com.library.utilities.BrowserUtils;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("libraryUrl"));
    }

    @After
    public void tearDownScenario(Scenario scenario) throws InterruptedException {
        //if my scenario failed
        // go and take screen shot

        if (scenario.isFailed()) {
            byte[] screenShot = ( (TakesScreenshot) Driver.getDriver() ).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());
        }

        BrowserUtils.sleep(5);
        Driver.closeDriver();

    }
}

