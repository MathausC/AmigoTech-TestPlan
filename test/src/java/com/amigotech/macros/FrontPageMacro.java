package test.src.java.com.amigotech.macros;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.src.java.com.amigotech.paths.FrontPagePath;

public final class FrontPageMacro {

    public static void loginIntoPage(String userName, String password) {
       Selenium.type(FrontPagePath.USER_NAME_INPUT.toString(), userName);
       Selenium.type(FrontPagePath.PASSWORD_INPUT.toString(), password);
       Selenium.clickAt(FrontPagePath.LOGIN_BUTTON.toString());
    }

    public static void tearDownItens() {
        Selenium.clickNoError(FrontPagePath.MENU_BURGER.toString());
        Selenium.clickNoError(FrontPagePath.RESET_APP_STATE_BUTTON.toString());
        Selenium.clickNoError(FrontPagePath.LOGOUT_BUTTON.toString());
    }

}
