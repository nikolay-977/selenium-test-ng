package ru.skillfactory.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        return new ChromeDriver(options);
    }
}