package step.definitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.ScreenObject;
import com.codeborne.selenide.appium.SelenideAppium;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import page.object.LoginScreen;
import page.object.SamplesListScreen;
import providers.AndroidProvider;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Slf4j
public class SmokeStepDefinitions {

    @Before
    public void setupConfig() {
        log.info("Starting new scenario");
        Configuration.browser = AndroidProvider.class.getName();
        SelenideAppium.launchApp();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenShotBytes = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShotBytes, "image/png", "Failed scenario screenshot");
        }
    }

    @Given("^User runs mobile application$")
    public void userRunsMobileApplication() {
        log.info("User is navigated to Login screen");
        var loginScreen = ScreenObject.screen(LoginScreen.class);
        loginScreen.waitForHeaderLogoVisibility();

        Assertions.assertThat(loginScreen.isUserNameInputEmpty() && loginScreen.isPasswordInputEmpty())
                .as("UserName/ Password must be filled with text!")
                .isFalse();
    }

    @When("^User login via first screen menu and navigated to Home screen$")
    public void userLoginViaFirstScreenMenu() {
        log.info("Login to application");
        ScreenObject.screen(LoginScreen.class).clickLoginButton();
    }

    @Then("^User returns back to Login screen$")
    public void userReturnsBackLoginScreen() {
        log.info("User is navigated back");
        ScreenObject.screen(SamplesListScreen.class).navigateBack();
        ScreenObject.screen(LoginScreen.class).waitForHeaderLogoVisibility();
    }

    @Then("^User returns back to Home screen$")
    public void userReturnsBackToHomeScreen() {
        log.info("User is navigated back");
        ScreenObject.screen(SamplesListScreen.class).navigateBack();
    }

    @And("User opens {string} menu, use it's UI element and set value {string}")
    public void userOpensSliderMenuAndUseItsElementForVerification(@NonNull String menuItem, @NonNull String value) {
        log.info("Verify [{}] action from Samples list", menuItem);
        var samplesScreen = ScreenObject.screen(SamplesListScreen.class);

        switch (menuItem) {
            case "Slider" -> samplesScreen.slide(value);
            case "Vertical swiping" -> samplesScreen.verticalSwipe(value);
            case "Double tap" -> samplesScreen.doubleTap();
            case "Wheel picker" -> samplesScreen.wheelPicker(value);
            default -> throw new IllegalArgumentException("Not implemented for [%s]!".formatted(menuItem));
        }
    }
}
