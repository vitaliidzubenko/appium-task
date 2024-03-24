package providers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.URL;

import static config.ConfigData.*;

public class AndroidProvider implements WebDriverProvider {

    @Nonnull
    @Override
    @SneakyThrows
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        var androidUrl = new URL("http://%s:%s".formatted(APPIUM_IP, APPIUM_PORT));
        var options = new UiAutomator2Options();

        options.setPlatformName(PLATFORM_NAME);
        options.setPlatformVersion(PLATFORM_VERSION);
        options.setDeviceName(DEVICE_NAME);
        options.setApp(new File(ANDROID_APP_FILE_NAME).getAbsolutePath());
        options.setAutoGrantPermissions(true);
        return new AndroidDriver(androidUrl, options);
    }
}
