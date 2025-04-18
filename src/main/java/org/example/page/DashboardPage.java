package org.example.page;

import org.example.utils.Waithelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

    WebDriver driver;
    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By dashboard_user= By.xpath("//span[@data-qa='lufexuloga']");


    public String dashboard_login_page()
    {
      // WebElement ele =driver.findElement(dashboard_user);
        Waithelper.checkVisibility(driver,dashboard_user);
        //Waithelper.checkVisibilityofelement(driver,ele);
        String dash_user_name=driver.findElement(dashboard_user).getText();
        return dash_user_name;
    }
}
