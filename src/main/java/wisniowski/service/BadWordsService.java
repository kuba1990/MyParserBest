package wisniowski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wisniowski.configuration.WordsConfig;
import wisniowski.model.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class BadWordsService {

    private List<String> badWords = new ArrayList<>();
    private WordsConfig wordsConfig;

    @Autowired
    public BadWordsService(WordsConfig wordsConfig) {
        this.wordsConfig = wordsConfig;
        fillList();
    }

    private void fillList() {
        badWords.addAll(Arrays.asList(wordsConfig.getWords().split(",")));
    }

    public Message badWordsReplacer(String content) {
        Message message = new Message();
        message.setContent(content.replaceAll(censorWords(), "*"));
        return message;
    }

    private String censorWords() {
        StringBuilder sb = new StringBuilder();
        for (String w : badWords) {
            if (sb.length() > 0) {
                sb.append("|");
            }
            sb.append(String.format("(?<=(?=%s).{0,%d}).", Pattern.quote(w), w.length() - 1));
        }
        return sb.toString();
    }
}
