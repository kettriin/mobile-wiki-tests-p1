package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:remote.properties"
})

public interface WikiConfig extends Config {

    @Key("browserstack.user")
    String browserstackUser();

    @Key("browserstack.key")
    String browserstackKey();

    @Key("appName")
    String appName();

    @Key("deviceName")
    String deviceName();

    @Key("androidVersion")
    String androidVersion();
}
