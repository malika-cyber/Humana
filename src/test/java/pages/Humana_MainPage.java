package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Humana_MainPage {
    public Humana_MainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//input[@placeholder='Search']")
    public WebElement searchField;

    @FindBy(xpath="//a[@aria-label='Search']")
    public WebElement searchButton;


    @FindBy(xpath="//h1[contains(text(), 'Search Results')]")
    public WebElement searchResultTextExpected;

    @FindBy(xpath="//span[contains(text(), 'Shop for Plans')]")
    public WebElement shopForPlanDropdown;

    @FindBy(xpath="//*[@id=\"navCatMedicaidPanel\"]/li[2]/a/span")
    public WebElement findADoctorUnderMedicaid;

    @FindBy(xpath="//input[@type='zip']")
    public WebElement zipCodeField;

    @FindBy(xpath="//*[@id=\"show-hide-search\"]/form/div[2]/div[1]/div/div[1]/div/button")
    public WebElement selectCategory;

    @FindBy(xpath="//label[@id='nucleus-radio-button-7-label']")
    public WebElement medicaidCheckbox;

    @FindBy(xpath="//span[ contains(text(), 'in your ZIP code')]")
    public WebElement errorMessage;

    @FindBy(xpath=" //select[@name='distance']")
    public WebElement dropdown;

}
