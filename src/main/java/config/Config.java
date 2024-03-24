package config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;

import static java.lang.System.getenv;

@Slf4j
@SuppressWarnings("java:S3398")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Config {

    public static AppConfig appConfig() {
        return AppConfigHolder.APP_CONFIG;
    }

    private static <T extends org.aeonbits.owner.Config> T create(Class<? extends T> clazz) {
        return ConfigFactory.create(clazz, System.getProperties(), getenv());
    }

    private static final class AppConfigHolder {
        private static final AppConfig APP_CONFIG = create(AppConfig.class);
    }

}
