package wisniowski.Regex;

import org.springframework.stereotype.Component;
import wisniowski.configuration.PatternConfig;

@Component
public class RegexConfigEN implements RegexNumber {

    private PatternConfig patternConfig;

    public RegexConfigEN(PatternConfig patternConfig) {
        this.patternConfig = patternConfig;
    }

    @Override
    public String format() {
        String regex = patternConfig.getPatterns().get(1);
        return regex;
    }
}
