package org.example.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.basetest.CommanToAllTest;
import org.example.listeners.RetryAnalyzer;
import org.example.listeners.ScreenShotListnerCOM;
import org.example.page.LoginPage;
import org.example.utils.ExcelUtils;
import org.example.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.example.driver.DriverManager.getDriver;



@Listeners(ScreenShotListnerCOM.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class Test_VWO_Login_DDT  extends CommanToAllTest {

    private static final Logger logger = LogManager.getLogger(Test_VWO_Login_DDT.class);
    @Test(dataProvider = "getData")
    public void test_login_with_DDT(String email,String password)
    {
        logger.info("Test case started");
        LoginPage loginPage = new LoginPage(getDriver());
        String error_msg = loginPage.vwo_login_with_invalid_creds(email, password);

        Assert.assertEquals(error_msg, PropertiesReader.readKey("expected_error_msg"));

    }

    @DataProvider
    public Object[][] getData()
    {
        return ExcelUtils.readDatafromExcel("Sheet1");
    }
}
