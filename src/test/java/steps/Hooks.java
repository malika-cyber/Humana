package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.Driver;
import utilities.EnvironmentManager;

public class Hooks {
    @Before
    public void setUp() throws Exception {
        EnvironmentManager.SetUpEnv();
    }
    @After()
    public void tearDown(Scenario scenario) throws Exception {

        Driver.takesScreenshot(scenario);
        Driver.closeDriver();

    }
}
