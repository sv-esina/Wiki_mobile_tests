package config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:local_driver.properties"})

public interface LocalConfig extends Config {

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("platformName")
    String getPlatformName();

    @Key("deviceName")
    String getDeviceName();

}
