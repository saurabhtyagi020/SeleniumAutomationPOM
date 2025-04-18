package org.example.basetest;

import org.example.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class CommanToAllTest {

    @BeforeMethod
    public void setup()
    {
        DriverManager.openBrowser();
    }

    @AfterMethod
    public void tearDown()
    {
      DriverManager.closeBrowser();
    }

}
