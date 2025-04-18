package org.example.test;

import io.qameta.allure.Description;
import org.example.basetest.CommanToAllTest;
import org.example.page.DashboardPage;
import org.example.page.LoginPage;
import org.example.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.driver.DriverManager.getDriver;

public class Test_Vwo_Login extends CommanToAllTest {


    @Description("Verify the vwo login with invalid credential")
    @Test(priority = 1,enabled = true)
    public void test_vwo_login_invalidCred() {

        LoginPage loginPage = new LoginPage(getDriver());
        String error_message=loginPage.vwo_login_with_invalid_creds(PropertiesReader.readKey("invalid_email"),PropertiesReader.readKey("invalid_pass"));

       Assert.assertEquals(error_message,PropertiesReader.readKey("expected_error_msg"));

    }

    @Description("Verify the vwo login with valid login cred")
    @Test(priority = 2)
    public void test_vwo_login_validCred()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.vwo_login_withValid_cred(PropertiesReader.readKey("valid_email"),PropertiesReader.readKey("valid_Pass"));

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        String logged_user = dashboardPage.dashboard_login_page();

        Assert.assertEquals(logged_user,PropertiesReader.readKey("expected_dashboard"));
    }
}
