package wisniowski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import wisniowski.formatter.PhoneNumberFormatter;
import wisniowski.model.Message;

@Service
public class NumberService {

    @Qualifier("PhoneNumberFormatterPL")
    private PhoneNumberFormatter phoneNumberFormatterPL;

    @Qualifier("PhoneNumberFormatterEN")
    private PhoneNumberFormatter phoneNumberFormatterEN;

    @Autowired
    public NumberService(PhoneNumberFormatter phoneNumberFormatterPL, PhoneNumberFormatter phoneNumberFormatterEN) {
        this.phoneNumberFormatterPL = phoneNumberFormatterPL;
        this.phoneNumberFormatterEN = phoneNumberFormatterEN;
    }

    public String languageDispatcher(Message message) {
        switch (message.getTitle()) {
            case "PL":
                return phoneNumberFormatterPL.format(message.getContent());
            case "EN":
                return phoneNumberFormatterEN.format(message.getContent());
            default:
                throw new IllegalArgumentException("Invalid title ");
        }

    }

}
