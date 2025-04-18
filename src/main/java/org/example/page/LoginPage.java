package org.example.page;

import org.example.utils.PropertiesReader;
import org.example.utils.Waithelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.driver.DriverManager.driver;
import static org.example.driver.DriverManager.getDriver;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By email_add= By.xpath("//input[@id='login-username']");
    private By email_pass = By.xpath("//input[@id='login-password']");
    private By signIn_button = By.xpath("//button[@id='js-login-btn']");

    private By error_msg=By.xpath("//div[@id='js-notification-box-msg']");


    public String vwo_login_with_invalid_creds(String user,String pwd)
    {
        getDriver().get(PropertiesReader.readKey("url"));
        driver.findElement(email_add).sendKeys(user);
        driver.findElement(email_pass).sendKeys(pwd);
        driver.findElement(signIn_button).click();

        Waithelper.checkVisibility(getDriver(),error_msg);

        String error_msg_notification = driver.findElement(error_msg).getText();
        return error_msg_notification;

    }
    public void vwo_login_withValid_cred(String user,String pwd)
    {
        getDriver().get(PropertiesReader.readKey("url"));
        driver.findElement(email_add).sendKeys(user);
        driver.findElement(email_pass).sendKeys(pwd);
        driver.findElement(signIn_button).click();




    }


}
