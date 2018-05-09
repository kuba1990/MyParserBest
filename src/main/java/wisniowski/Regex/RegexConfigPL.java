package wisniowski.Regex;

import org.springframework.stereotype.Component;
import wisniowski.configuration.PatternConfig;

@Component
public class RegexConfigPL implements RegexNumber {

    private PatternConfig patternConfig;

    public RegexConfigPL(PatternConfig patternConfig) {
        this.patternConfig = patternConfig;
    }

    @Override
    public String format() {
        String regex = patternConfig.getPatterns().get(0);
        return regex;
    }
}
