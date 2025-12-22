package ru.skillfactory.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.skillfactory.pages.VkVideoPage;
import ru.skillfactory.utils.WebDriverFactory;

public class VkVideoTests {

    private WebDriver driver;
    private VkVideoPage vkVideoPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = WebDriverFactory.createDriver();
        driver.manage().window().maximize();
        vkVideoPage = new VkVideoPage(driver);
        vkVideoPage.open();
    }

    @Test
    public void mainPageOpenedTest() {
        Assert.assertTrue(vkVideoPage.isMainPageOpened(), "VkVideo main page is not opened.");
    }

    @Test
    public void burgerMenuClickTest() {
        vkVideoPage.burgerMenuClick();
        Assert.assertTrue(vkVideoPage.mainBtnIsNotDisplayed(), "Burger menu is displayed.");
    }

    @Test
    public void searchInputTest() {
        vkVideoPage.inputSearchText("Программирование на Java с нуля");
        Assert.assertTrue(vkVideoPage.getJavaVideo(), "Video is not found.");
    }

    @Test
    public void clickFirstVideoTest() {
        vkVideoPage.isFirstVideoDisplayed();
        String href = vkVideoPage.getFirstVideoCardAttribute("href");
        vkVideoPage.firstVideoClick();
        vkVideoPage.isVideoModalDisplayed();
        String url = vkVideoPage.getCurrentUrl();
        Assert.assertTrue(url.contains(href), "Current url is not same as href");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}