package ru.skillfactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.openqa.selenium.Keys.ENTER;

public class VkVideoPage {

    private static final String BASE_URL = "https://vkvideo.ru";
    private final WebDriver driver;
    private final WebDriverWait wait;
    @FindBy(xpath = "//a[@aria-label='На главную VK Видео']")
    private WebElement logoLabel;

    @FindBy(id = "video_left_menu_toggle")
    private WebElement burgerMenu;

    @FindBy(xpath = "//h4[contains(@class, 'vkuiHeadline__level2') and text()='Главная']")
    private WebElement mainBtn;

    @FindBy(id = "video_service_search_input")
    private WebElement searchInput;

    @FindBy(xpath = "//a[@title='Программирование на Java с нуля #4. Классы и методы.']")
    private WebElement javaVideo;

    @FindBy(xpath = "(//a[contains(@class, 'VideoCard__title')])[1]")
    private WebElement videoCard;

    @FindBy(xpath = "//div[@data-testid='video_modal_title']")
    private WebElement videoModal;

    public VkVideoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public boolean isMainPageOpened() {
        try {
            return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(logoLabel))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void burgerMenuClick() {
        wait.until(ExpectedConditions.visibilityOf(burgerMenu));
        burgerMenu.click();
    }

    public boolean mainBtnIsNotDisplayed() {
        try {
            return wait.until(ExpectedConditions.invisibilityOf(mainBtn));
        } catch (Exception e) {
            return false;
        }
    }

    public void inputSearchText(String text) {
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(searchInput))).clear();
        searchInput.sendKeys(text);
        searchInput.sendKeys(ENTER);
    }

    public boolean getJavaVideo() {
        try {
            return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(javaVideo))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void isFirstVideoDisplayed() {
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(videoCard))).isDisplayed();
    }

    public void isVideoModalDisplayed() {
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(videoModal))).isDisplayed();
    }

    public void firstVideoClick() {
        videoCard.click();
    }

    public String getFirstVideoCardAttribute(String name) {
        try {
            wait.until(ExpectedConditions.visibilityOf(videoCard));
            return videoCard.getAttribute(name);
        } catch (Exception e) {
            return null;
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}