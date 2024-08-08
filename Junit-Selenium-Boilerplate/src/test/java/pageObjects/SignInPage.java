package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

/**
 * Created by jack.forman on 23/10/2016.
 */
public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    private static final By EMAIL_ADDRESS_INPUT_BOX = By.cssSelector(".col-md-6 input[name='email']");
    private static final By FIRST_NAME = By.cssSelector(".col-md-6 input[name='firstname']");
    private static final By LAST_NAME = By.cssSelector(".col-md-6 input[name='lastname']");
    private static final By PASSWORD = By.cssSelector(".col-md-6 .input-group input[name='password']");

    private static final By CREATE_NEW_ACCOUNT_BUTTON = By.cssSelector(".no-account a");

    private static final By REGISTERED_BUTTON = By.cssSelector("footer.form-footer .btn.btn-primary.form-control-submit.float-xs-right[type='submit']");


    //private static final By SIGN_IN_PAGE = By.cssSelector("footer.form-footer .btn.btn-primary.form-control-submit.float-xs-right[type='submit']");
    private static final By SIGN_IN_BUTTON = By.cssSelector("button.btn.btn-primary[data-link-action='sign-in']");
    private static final By SIGN_OUT_BUTTON = By.cssSelector("a.logout.hidden-sm-down");

    private static final By ALREADY_REGISTERED_ALERT = By.cssSelector(".alert.alert-danger");

    private static final By RESET_EMAIL = By.cssSelector(".col-md-5.email input[type='email'][name='email']");

    private static final By FORGOTTEN_PASSWORD_LINK = By.cssSelector(".forgot-password a");

    private static final By ACCOUNT_PAGE_BUTTON = By.cssSelector("a.account[href*='controller=my-account']");
    private static final By RESET_PASSWORD_BUTTON = By.cssSelector(".form-control-submit.btn.btn-primary.hidden-xs-down[name='submit']");

    public void enterEmailAddress(String emailAddress){
        findAndType(EMAIL_ADDRESS_INPUT_BOX, emailAddress);
    }

    public void enterFirstName(String firstName){
        findAndType(FIRST_NAME, firstName);
    }
    public void enterLastName(String lastName){
        findAndType(LAST_NAME, lastName);
    }
    public void enterPassword(String password){
        findAndType(PASSWORD, password);
    }
    public void clickCreateAnAccount(){
        waitAndClick(CREATE_NEW_ACCOUNT_BUTTON);
    }
    public String newEmail = getNewEmail();
    public void navigateToAccountPage(){
        waitAndClick(ACCOUNT_PAGE_BUTTON);
    }
    public void logout(){
        waitAndClick(SIGN_OUT_BUTTON);
    }

    public void clickRegisterButton(){
        waitAndClick(REGISTERED_BUTTON);
    }

    public void clickSignInButton(){
        waitAndClick(SIGN_IN_BUTTON);
    }

    public void alreadyRegisteredAlertPresent(){
        WebElement alertBox = driver.findElement(ALREADY_REGISTERED_ALERT);
        Assert.assertTrue(elementIsVisible(alertBox));
    }

    public String getNewEmail(){
        int random = new Random().nextInt(10000);
        return "test" + random + "@test.com";
    }

    public void forgotPassword(){
        waitAndClick(FORGOTTEN_PASSWORD_LINK);
    }

    public void resetPassword(){
        waitAndClick(RESET_PASSWORD_BUTTON);
    }

    public void resetEmail(String emailAddress){
        findAndType(RESET_EMAIL, emailAddress);
    }

}
