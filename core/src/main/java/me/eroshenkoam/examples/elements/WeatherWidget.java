package me.eroshenkoam.examples.elements;

import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * @author eroshenkoam
 */
public class WeatherWidget extends HtmlElement {

    @FindBy(css = "h1>a.link_blue_yes")
    private WebElement title;

    @FindBy(css = "h1>a>i.weather__icon")
    private WebElement icon;

    @FindBy(css = "div.weather__item>a")
    private WebElement dayTemperature;

    @FindBy(css = "div.weather__item>a+a")
    private WebElement nightTemperature;

    @FindBy(css = "h1>a.link_black_yes")
    private WebElement currentTemperature;

    public WebElement getTitle() {
        return title;
    }

    public WebElement getIcon() {
        return icon;
    }

    public WebElement getCurrentTemperature() {
        return currentTemperature;
    }

    public WebElement getDayTemperature() {
        return dayTemperature;
    }

    public WebElement getNightTemperature() {
        return nightTemperature;
    }

    public Rectangle getRect() {
        return null;
    }
}
