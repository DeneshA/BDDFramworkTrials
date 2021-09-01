package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class amazonHome_PF {
    WebDriver driver;

    @FindBy(id="twotabsearchtextbox")
    WebElement txt_SearchBox;

    @FindBy(xpath = "//input[@id=\"nav-search-submit-button\"]")
    WebElement btn_searchButton;

    public amazonHome_PF(WebDriver driver){
        //Initializing Pagefactory webb Elements
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void enterTextInSearchBox(String text){

        txt_SearchBox.clear();
        txt_SearchBox.sendKeys(text);

    }

    public void clickOnSearchButton(){

        btn_searchButton.click();

    }
}
