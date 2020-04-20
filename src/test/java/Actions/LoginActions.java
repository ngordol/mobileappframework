package Actions;

import Pages.LoginPage;

public class LoginActions extends LoginPage {

    public void clickLogin() {
        login().click();
        email().click();
        email().sendKeys(accountEmail());
        continueBTN().click();
        password().click();
        password().sendKeys(accountPassword());
        signIn().click();
    }
}
