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
    private RegexNumber regexConfigEN;

    @Qualifier("RegexConfig")
    private RegexNumber regexConfigPL;

    public FindNumberInContentService(RegexNumber regexConfigEN, RegexNumber regexConfigPL) {
        this.regexConfigEN = regexConfigEN;
        this.regexConfigPL = regexConfigPL;
    }

    public List<String> getNumbers(String content) {
        String[] words = content.split("\\s");
        for (String s : words) {
            if (s.matches((regexConfigPL.format())) || s.matches((regexConfigEN.format()))) {
                getNumber.add(s);
            }
        }
        return getNumber;
    }
}






