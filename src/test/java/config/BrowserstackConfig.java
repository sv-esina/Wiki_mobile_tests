package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:browserstack.properties")

public interface BrowserstackConfig extends Config {

    @Key("browserstack.user")
    String browserstackUser();

    @Key("browserstack.key")
    String browserstackKey();

    @Key("browserstackUrl")
    String getBrowserstackUrl();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOsVersion();

    @Key("app")
    String getApp();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String name();

}