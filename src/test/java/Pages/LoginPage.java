package Pages;

import core.AndroidLocator;
import io.appium.java_client.android.AndroidElement;
import utils.ObjectReader;

public class LoginPage  extends AndroidLocator {
    private ObjectReader page;
    private ObjectReader account;

    public LoginPage(){

        page = new ObjectReader("support/pageElements/loginPage.yml");
        account = new ObjectReader("support/testAccount/account.yml");
    }

    protected String accountEmail(){ return account.getKey("userOne"+".email");}

    protected String accountPassword(){ return account.getKey("userOne"+".password");}

    protected AndroidElement login(){ return getLocator(page, "login"); }

    protected AndroidElement email(){ return getLocator(page, "email");}

    protected AndroidElement continueBTN() { return getLocator(page, "continue");}

    protected AndroidElement password() { return getLocator(page, "password");}

    protected AndroidElement signIn(){ return getLocator(page, "signin");}
}
