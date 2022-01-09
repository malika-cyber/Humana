package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.Humana_MainPage;
import utilities.Driver;
import utilities.HelperClass;

public class Humana_ValidationSteps {
    WebDriver driver = Driver.getDriver();
    Humana_MainPage humana_mainPage = new Humana_MainPage();

    @Given("^the user is on the \"([^\"]*)\" homepage$")
    public void the_user_is_on_the_homepage(String windowName) throws Throwable {
    driver.navigate().to("https://www.humana.com/");
    }

    @Then("^verify title contains \"([^\"]*)\"$")
    public void verify_title_contains(String expectedTitle) throws Throwable {
        String actualTitle = driver.getTitle();
        Assert.assertTrue("Failure verification of expected title", actualTitle.contains(expectedTitle));
    }

    @When("^the user executes the searches for \"([^\"]*)\" in \"([^\"]*)\" field$")
    public void the_user_executes_the_searches_for_in_field(String searchText, String fieldName) throws Throwable {
        HelperClass.highlightElement(humana_mainPage.searchField);
        humana_mainPage.searchField.sendKeys("find a doctor");
    }

    @When("^the user clicks on \"([^\"]*)\" button$")
    public void the_user_clicks_on_button(String buttonName) throws Throwable {
        HelperClass.highlightElement(humana_mainPage.searchButton);
        humana_mainPage.searchButton.click();
    }

    @Then("^verify that user see \"([^\"]*)\"$")
    public void verify_that_user_see(String arg1) throws Throwable {
        HelperClass.highlightElement(humana_mainPage.searchResultTextExpected);
        Assert.assertTrue("Failure verification of search field", humana_mainPage.searchResultTextExpected.isDisplayed());
    }

    @When("^the user clicks on \"([^\"]*)\"$")
    public void the_user_clicks_on(String shopDropdown) throws Throwable {
        HelperClass.highlightElement(humana_mainPage.shopForPlanDropdown);
        humana_mainPage.shopForPlanDropdown.click();
    }

    @When("^the user clicks on \"([^\"]*)\" under \"([^\"]*)\"$")
    public void the_user_clicks_on_under(String serviceName, String category) throws Throwable {
        HelperClass.highlightElement(humana_mainPage.findADoctorUnderMedicaid);
        humana_mainPage.findADoctorUnderMedicaid.click();
    }

    @When("^the user enters search criteria \"([^\"]*)\" (\\d+) miles and \"([^\"]*)\" (\\d+)$")
    public void the_user_enters_search_criteria_miles_and(String arg1, int arg2, String arg3, int arg4) throws Throwable {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='distance']")));
        HelperClass.highlightElement(humana_mainPage.dropdown);
        dropdown.selectByValue("15");

        HelperClass.highlightElement(humana_mainPage.zipCodeField);
        humana_mainPage.zipCodeField.sendKeys("60026");
    }

    @When("^the user select a lookup method \"([^\"]*)\" \"([^\"]*)\"$")
    public void the_user_select_a_lookup_method(String method, String type) throws Throwable {
        HelperClass.highlightElement(humana_mainPage.selectCategory);
        humana_mainPage.selectCategory.click();

        HelperClass.highlightElement(humana_mainPage.medicaidCheckbox);
        humana_mainPage.medicaidCheckbox.click();
    }

    @Then("^the user see error message \"We're sorry, there are no plans of this coverage type available in your ZIP code\\.$")
    public void the_user_see_error_message_We_re_sorry_there_are_no_plans_of_this_coverage_type_available_in_your_ZIP_code() throws Throwable {
    String expectedErrorMessage = "no plans of this coverage type available in your ZIP code.";
    String actualErrorMessage = humana_mainPage.errorMessage.getText();
    HelperClass.highlightElement(humana_mainPage.errorMessage);
        Assert.assertTrue("Failure verification error message", actualErrorMessage.contains(expectedErrorMessage));
    }

}
