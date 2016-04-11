package me.eroshenkoam.examples.steps;

import me.eroshenkoam.examples.beans.Temperature;
import me.eroshenkoam.examples.beans.Weather;
import me.eroshenkoam.examples.elements.WeatherWidget;
import me.eroshenkoam.examples.pages.MainPage;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.regex.Pattern;

import static me.eroshenkoam.examples.utils.PatternUtils.findFirstGroup;

/**
 * @author eroshenkoam
 */
public class CommonUserSteps {

    private MainPage mainPage;

    public CommonUserSteps(WebDriver driver) {
        this.mainPage = new MainPage(driver);
    }

    @Step
    public void openMainPage() {
        mainPage.open();
    }

    @Step
    public Weather getWeather() {
        WeatherWidget weatherWidget = mainPage.getWeatherWidget();
        String title = weatherWidget.getTitle().getText();

        String currentTemperature = findFirstGroup(Pattern.compile("-?\\d+"),
                weatherWidget.getCurrentTemperature().getText());
        if (currentTemperature == null) {
            throw new NullPointerException("Weather temperature can not be null");
        }

        String dayTemperature = findFirstGroup(Pattern.compile("-?\\d+"),
                weatherWidget.getDayTemperature().getText());
        if (dayTemperature == null) {
            throw new NullPointerException("Weather day temperature can not be null");
        }

        String nightTemperature = findFirstGroup(Pattern.compile("-?\\d+"),
                weatherWidget.getNightTemperature().getText());
        if (nightTemperature == null) {
            throw new NullPointerException("Weather night temperature can not be null");
        }

        return new Weather()
                .withTitle(title)
                .withTemperature(new Temperature()
                        .withDay(Integer.parseInt(dayTemperature))
                        .withNight(Integer.parseInt(nightTemperature))
                        .withCurrent(Integer.parseInt(currentTemperature))
                );
    }


}
