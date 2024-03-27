package encora.pages;

import encora.Data;
import encora.Util;
import encora.base.BasePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {

    @FindBy(linkText = "Register")
    private WebElement txtLinkText;
    @FindBy(id = "customer.firstName")
    private WebElement inputFirstName;

    @FindBy(id = "customer.lastName")
    private WebElement inputLastName;

    @FindBy(id = "customer.address.street")
    private WebElement inputAddressStreet;

    @FindBy(id = "customer.address.city")
    private WebElement inputAddressCity;

    @FindBy(id = "customer.address.state")
    private WebElement inputAddressState;

    @FindBy(id = "customer.address.zipCode")
    private WebElement inputAddressZipCode;

    @FindBy(id = "customer.phoneNumber")
    private WebElement inputPhoneNumber;

    @FindBy(id = "customer.ssn")
    private WebElement inputSsn;

    @FindBy(id = "customer.username")
    private WebElement inputUsername;

    @FindBy(id = "customer.password")
    private WebElement inputPassword;

    @FindBy(id = "repeatedPassword")
    private WebElement inputRepeatedPassword;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement btnRegister;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
    private WebElement lblRightPanel;

    @FindBy(linkText = "Log Out")
    private WebElement btnLogOut;

    @FindBy(name = "username")
    private WebElement inputUserName;

    @FindBy(name = "password")
    private WebElement inputPasswordLogin;

    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div/h1")
    private WebElement lblLoginText;


    @Test
    public void testRegister() {
        PageFactory.initElements(BasePage.getDriver(),this);

        String name, password;
        name = "Diego" + Util.getNumeroAleatorio();
        password = "123456";

        txtLinkText.click();
        inputFirstName.sendKeys(Data.FIRST_NAME);
        inputLastName.sendKeys(Data.LAST_NAME);
        inputAddressStreet.sendKeys(Data.ADDRESS_STREET);
        inputAddressCity.sendKeys(Data.ADDRESS_CITY);
        inputAddressState.sendKeys(Data.ADDRESS_STATE);
        inputAddressZipCode.sendKeys(Data.ZIP_CODE);
        inputPhoneNumber.sendKeys(Data.PHONE_NUMBER);
        inputSsn.sendKeys(Data.SNN);
        inputUsername.sendKeys(name);
        inputPassword.sendKeys(password);
        inputRepeatedPassword.sendKeys(password);
        btnRegister.click();
        Assert.assertTrue(lblRightPanel.isDisplayed());
        System.out.println(lblRightPanel.getText());

        //Log Out
        btnLogOut.click();

        //Log IN
        inputUserName.sendKeys(name);
        inputPasswordLogin.sendKeys(password);
        btnLogin.click();

        lblLoginText.isDisplayed();
        System.out.println(lblLoginText.getText());
        Assert.assertEquals(lblLoginText.getText(), "Accounts Overview");
    }


}
