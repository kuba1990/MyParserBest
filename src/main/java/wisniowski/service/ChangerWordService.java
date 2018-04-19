package wisniowski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wisniowski.configuration.DaysConfig;

import java.util.Map;

@Service
public class ChangerWordService {

    private DaysConfig daysConfig;

    @Autowired
    public ChangerWordService(DaysConfig daysConfig) {
        this.daysConfig = daysConfig;
    }

    public String replaceWrongWord(String content) {
        for (Map.Entry<String, String> entry : daysConfig.getMappingDays().entrySet()) {
            content = content.replaceAll(entry.getKey(), entry.getValue());
        }
        return content;
    }
}