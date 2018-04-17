package wisniowski.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import wisniowski.Regex.RegexNumber;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindNumberInContentService {

    private static List<String> getNumber = new ArrayList<String>();

    @Qualifier("RegexConfig")
    private RegexNumber regexConfig;

    public FindNumberInContentService(RegexNumber regexConfig) {
        this.regexConfig = regexConfig;
    }

    public List<String> getNumbers(String content) {
        String[] words = content.split("\\s");
        for (String s : words) {
            if (s.matches((regexConfig.format()))) {
                getNumber.add(s);
            }
        } return getNumber;
    }
}






