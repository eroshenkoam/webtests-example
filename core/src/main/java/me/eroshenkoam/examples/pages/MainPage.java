package me.eroshenkoam.examples.pages;

import me.eroshenkoam.examples.elements.WeatherWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * @author eroshenkoam
 */
public class MainPage {

    private static final String MAIN_PAGE_URL = "https://www.yandex.ru";

    private final WebDriver driver;

    @FindBy(css = "div.weather")
    private WeatherWidget weatherWidget;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        this.driver = driver;
    }

    public void open() {
        driver.get(MAIN_PAGE_URL);
    }

    public WeatherWidget getWeatherWidget() {
        return weatherWidget;
    }
}
