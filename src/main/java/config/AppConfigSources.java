package config;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AppConfigSources {
    public static final String CONFIGURATION_FILE = "classpath:application.properties";
    public static final String SYSTEM_ENV = "system:env";
    public static final String SYSTEM_PROPS = "system:properties";
}
