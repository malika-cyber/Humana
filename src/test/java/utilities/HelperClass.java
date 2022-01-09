package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class HelperClass {
    //this class will store reusable methods

    public static void highlightElement(WebElement element) {
        //String style = "border: 4 px solid red";
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red')", element);
    }


}
