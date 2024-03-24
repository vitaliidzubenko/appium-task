package providers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.URL;

import static config.ConfigData.*;

public class IosProvider implements WebDriverProvider {

    @Nonnull
    @Override
    @SneakyThrows
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        var iosUrl = new URL("http://%s:%s".formatted(APPIUM_IP, APPIUM_PORT));
        var options = new XCUITestOptions();

        options.setPlatformName(PLATFORM_NAME);
        options.setPlatformVersion(PLATFORM_VERSION);
        options.setDeviceName(DEVICE_NAME);
        options.setApp(new File(IOS_APP_FILE_NAME).getAbsolutePath());
        return new IOSDriver(iosUrl, options);
    }
}
