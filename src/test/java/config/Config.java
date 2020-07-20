package config;

import com.codeborne.selenide.Configuration;

public class Config {
    private static Config instance;
    private Config() {
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    static {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1200x800";
    }

    public String getUrl() {
        return Configuration.baseUrl;
    }
}
