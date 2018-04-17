package wisniowski.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class PatternConfig {

    private List<String> patterns = new ArrayList<String>();

    public void setPatterns(List<String> patterns) {
        this.patterns = patterns;
    }
    public List<String> getPatterns() {
        return this.patterns;
    }
}
