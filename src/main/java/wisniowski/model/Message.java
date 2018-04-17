package wisniowski.model;

import javax.validation.constraints.NotNull;

public class Message {
    @NotNull
    private String title;
    private String content;
    private String regex;

    public Message(String s) {
    }

    public Message(String title, String content, String regex) {
        this.title = title;
        this.content = content;
        this.regex = regex;
    }

    public Message() {
    }

    public Message(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", regex='" + regex + '\'' +
                '}';
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}