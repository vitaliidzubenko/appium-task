package config;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConfigData {
    public static final int APPIUM_PORT = Config.appConfig().appiumPort();
    public static final String APPIUM_IP = Config.appConfig().appiumIp();
    public static final String DEVICE_NAME = Config.appConfig().deviceName();
    public static final String PLATFORM_VERSION = Config.appConfig().platformVersion();
    public static final String PLATFORM_NAME = Config.appConfig().platformName();
    public static final String ANDROID_APP_FILE_NAME = Config.appConfig().androidAppFileName();
    public static final String IOS_APP_FILE_NAME = Config.appConfig().iosAppFileName();

}
