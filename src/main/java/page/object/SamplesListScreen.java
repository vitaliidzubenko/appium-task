package page.object;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.AppiumScrollOptions;
import com.codeborne.selenide.appium.ScrollDirection;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$x;

@Slf4j
public class SamplesListScreen extends AppiumAbstractPage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Slide your number\"]")
    @iOSXCUITFindBy(xpath = "iOSValue")
    private SelenideElement sliderMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Demos vertical swiping\")]")
    @iOSXCUITFindBy(xpath = "iOSValue")
    private SelenideElement verticalSwipeMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Demo double tap button\"]")
    @iOSXCUITFindBy(xpath = "iOSValue")
    private SelenideElement doubleTapMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Demos wheel picker color\"]")
    @iOSXCUITFindBy(xpath = "iOSValue")
    private SelenideElement wheelPickerMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[not(@resource-id=\"android:id/text1\")]")
    @iOSXCUITFindBy(xpath = "iOSValue")
    private SelenideElement wheelPickerDropDownItem;

    @AndroidFindBy(xpath = "//android.widget.SeekBar[@content-desc=\"slider\"]")
    @iOSXCUITFindBy(xpath = "iOSValue")
    private SelenideElement sliderElement;

    @AndroidFindBy(accessibility = "doubleTapMe")
    @iOSXCUITFindBy(xpath = "iOSValue")
    private SelenideElement doubleTapElement;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    @iOSXCUITFindBy(xpath = "iOSValue")
    private SelenideElement doubleTapSuccessButton;

    public SamplesListScreen slide(@NonNull String value) {
        log.info("Open 'Slider' menu, use slider element");
        $(sliderMenu).shouldBe(enabled).click();
        $(sliderElement).shouldBe(enabled).click(ClickOptions.withOffset(Integer.parseInt(value), 0));
        $(sliderElement).shouldNotHave(text("0.0"));
        return this;
    }

    public SamplesListScreen verticalSwipe(@NonNull String value) {
        log.info("Open 'Vertical swipe' menu, use slider element");
        $(verticalSwipeMenu).shouldBe(enabled).click();

        $(By.className("//android.view.ViewGroup")).scroll(AppiumScrollOptions.with(ScrollDirection.DOWN, 3));
        $x("//android.widget.TextView[contains(@text,\"%s\")]".formatted(value)).should(exist);
        return this;
    }

    public SamplesListScreen doubleTap() {
        log.info("Open 'Double tap' menu, use button element");
        $(doubleTapMenu).shouldBe(enabled).click();
        $(doubleTapElement).doubleTap();
        $(doubleTapSuccessButton).shouldBe(visible).click();
        return this;
    }

    public SamplesListScreen wheelPicker(@NonNull String value) {
        log.info("Open 'Wheel picker' menu");
        $(wheelPickerMenu).scrollTo().click();
        $(wheelPickerDropDownItem).should(exist).shouldNotHave(text("Current Color: %s".formatted(value)));

        log.info("Choose [{}] colour from dropDown list", value);
        $x("//android.widget.Spinner").shouldBe(enabled).click();
        $x("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"%s\"]".formatted(value)).click();

        $(wheelPickerDropDownItem).should(exist).shouldHave(text("Current Color: %s".formatted(value)));
        return this;
    }

    public void navigateBack() {
        super.clickBackButton();
    }
}
