package page.object;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.appium.SelenideAppium.$;

@Slf4j
@SuppressWarnings("java:S2094")
public abstract class AppiumAbstractPage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Back\"]")
    @iOSXCUITFindBy(xpath = "iOSValue")
    protected SelenideElement backButton;

    public void clickBackButton() {
        log.info("Click 'Back' button at the top bar");
        $(backButton).click();
    }

}
