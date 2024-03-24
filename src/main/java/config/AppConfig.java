package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(Config.LoadType.MERGE)
@Sources({AppConfigSources.SYSTEM_PROPS, AppConfigSources.SYSTEM_ENV, AppConfigSources.CONFIGURATION_FILE})
public interface AppConfig extends Config {

    @Key("appium.ip")
    String appiumIp();

    @Key("appium.port")
    int appiumPort();

    @Key("device.name")
    String deviceName();

    @Key("platform.version")
    String platformVersion();

    @Key("platform.name")
    String platformName();

    @Key("android.app.file.name")
    String androidAppFileName();

    @Key("ios.app.file.name")
    String iosAppFileName();

}
