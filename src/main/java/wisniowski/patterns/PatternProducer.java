package wisniowski.patterns;

import wisniowski.model.Message;

import java.util.regex.Pattern;

public interface PatternProducer {
    public Pattern pattern(Message message);
}
