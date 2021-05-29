package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/test_data.properties"
})
public interface TestDataConfig extends Config {
    @Key("api.url")
    String apiUrl();
}
