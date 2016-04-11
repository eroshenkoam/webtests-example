package me.eroshenkoam.examples;

import me.eroshenkoam.examples.beans.Weather;
import me.eroshenkoam.examples.rules.WebDriverRule;
import me.eroshenkoam.examples.steps.CommonUserSteps;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author eroshenkoam
 */
public class WeatherTest {

    @Rule
    public WebDriverRule webDriverRule = new WebDriverRule();

    private CommonUserSteps commonUserSteps;

    @Before
    public void initSteps() {
        commonUserSteps = new CommonUserSteps(webDriverRule.getDriver());
    }

    @Test
    public void testWeatherData() {
        commonUserSteps.openMainPage();
        Weather weather = commonUserSteps.getWeather();
        assertThat(weather.getTitle()).isEqualTo("Погода");
        assertThat(weather.getTemperature().getCurrent()).isBetween(-50, 50);
    }
}
