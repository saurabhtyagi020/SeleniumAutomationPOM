package org.example.base;

import org.example.driver.DriverManager;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommanToAllPage {

    public CommanToAllPage()
    {

    }

    public void openVwourl()
    {
        DriverManager.getDriver().get(PropertiesReader.readKey("url"));
    }

    public void clickElement(By by)
    {
        DriverManager.getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by)
    {
        by.click();;
    }

    public void enterInput(By by,String key)
    {
        DriverManager.getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by,String key)
    {
        by.sendKeys(key);
    }
    public String getText(By by)
    {
        return DriverManager.getDriver().findElement(by).getText();
    }

    public String getText(WebElement by)
    {
        return by.getText();
    }


}
