package wisniowski.formatter;

import org.springframework.stereotype.Component;
import wisniowski.configuration.PatternConfig;

@Component
public class PhoneNumberFormatterPL implements PhoneNumberFormatter {

    private PatternConfig patternConfig;

    public PhoneNumberFormatterPL(PatternConfig patternConfig) {
        this.patternConfig = patternConfig;
    }

    @Override
    public String format(String content) {
        String regex = patternConfig.getPatterns().get(1);
        String number = String.valueOf(content).replaceFirst(regex, "$1-$2-$3");
        return number;
    }
}
