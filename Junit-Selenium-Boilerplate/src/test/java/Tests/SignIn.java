package Tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.CreateNewAccountPage;
import pageObjects.ShoppingCartPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import static Tests.TestSuite.driverFactory;

/**
 * Created by jack.forman on 30/10/2016.
 */
public class SignIn {

    public static WebDriver driver = driverFactory.getDriver();
    private HomePage homepage = new HomePage(driver);
    private SignInPage signInPage = new SignInPage(driver);
    private CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(driver);



    @Before
    public void individualSetUp(){
        homepage.goTo();
    }


    /** Sign in as Registered User
     * Pre-Conditions - Must have signIn information for a registered user
     * Navigate to Sign In Page
     * Fill in Email Address
     * Fill in Password
     * Click Sign In
     * Verify My Account is Displayed
     */
    @Test
    public void signInAsRegisteredUser(){
        homepage.navigateToSignInPage();
        signInPage.enterEmailAddress("Test345@test.com");
        signInPage.enterPassword("Test345");
        signInPage.clickSignInButton();
        signInPage.navigateToAccountPage();
    }

    /**Cannot sign in as unregistered customer
     * Pre-Conditions - Must have Email address and Password of unregistered customer
     * Navigate to Sign in Page
     * Fill in Email Address
     * Fill in Password
     * Click Sign in
     * Verify Error Message is Displayed
     */
    @Test
    public void signInAsUnRegisteredUser(){

        homepage.navigateToSignInPage();
        signInPage.enterEmailAddress(signInPage.newEmail);
        signInPage.enterPassword("Test789");
        signInPage.clickSignInButton();
    }

    /** Forgotten Password
     * Pre-Conditions - Must have signIn information for a registered user
     * Navigate to Sign In Page
     * Click Forgotten Password
     * Enter E mail Address
     * Click retrieve password
     * Confirmation message displayed
     */
    @Test
    public void forgottenPassword(){
        homepage.navigateToSignInPage();
        signInPage.forgotPassword();
        signInPage.resetEmail(signInPage.getNewEmail());
        signInPage.resetPassword();
    }

    /**Able to sign out
     * Pre-Conditions - Must have signIn information for a registered user
     * Navigate to Sign In Page
     * Click sign out
     * Verify customer signed out
     */
    @Test
    public void signOut(){
        signInPage.logout();
        homepage.navigateToSignInPage();
        signInPage.enterEmailAddress("Test345@test.com");
        signInPage.enterPassword("Test345");
        signInPage.clickSignInButton();
        signInPage.logout();
    }
}
