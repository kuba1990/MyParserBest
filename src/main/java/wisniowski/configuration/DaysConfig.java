package wisniowski.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class DaysConfig {
    Map<String, String> mappingDays;

    public Map<String, String> getMappingDays() {
        return mappingDays;
    }

    public void setMappingDays(Map<String, String> mappingDays) {
        this.mappingDays = mappingDays;
    }
}
