package page.object;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static org.awaitility.Durations.TEN_SECONDS;

@Slf4j
public class LoginScreen extends AppiumAbstractPage {

    @AndroidFindBy(accessibility = "username")
    @iOSXCUITFindBy(accessibility = "iOSValue")
    private SelenideElement userNameInput;

    @AndroidFindBy(accessibility = "password")
    @iOSXCUITFindBy(accessibility = "iOSValue")
    private SelenideElement passwordInput;

    @AndroidFindBy(accessibility = "login")
    @iOSXCUITFindBy(accessibility = "iOSValue")
    private SelenideElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Login\"]")
    @iOSXCUITFindBy(xpath = "iOSValue")
    private SelenideElement headerElement;

    public LoginScreen waitForHeaderLogoVisibility() {
        log.info("Wait for header logo visibility at Login page");
        $(headerElement).shouldBe(visible, TEN_SECONDS);
        return this;
    }

    public boolean isUserNameInputEmpty() {
        return $(userNameInput).shouldBe(visible).getText().isEmpty();
    }

    public boolean isPasswordInputEmpty() {
        return $(passwordInput).shouldBe(visible).getText().isEmpty();
    }

    public SamplesListScreen clickLoginButton() {
        log.info("Click 'LOG IN' button");
        $(loginButton).shouldBe(enabled).click();
        return new SamplesListScreen();
    }

}
