package wisniowski.formatter;

import org.springframework.stereotype.Component;
import wisniowski.configuration.PatternConfig;
import wisniowski.configuration.WordsConfig;

@Component
public class PhoneNumberFormatterEN implements PhoneNumberFormatter {

   private PatternConfig patternConfig;

    public PhoneNumberFormatterEN(PatternConfig patternConfig) {
        this.patternConfig = patternConfig;
    }

    @Override
    public String format(String content) {
        String regex = patternConfig.getPatterns().get(0);
        String number = String.valueOf(content).replaceFirst(regex, "$1-$2-$3");
        return number;
    }
}

