package service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import wisniowski.formatter.PhoneNumberFormatter;
import wisniowski.formatter.PhoneNumberFormatterEN;
import wisniowski.formatter.PhoneNumberFormatterPL;
import wisniowski.model.Message;
import wisniowski.service.NumberService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class NumberServiceTest {
    private NumberService numberService;
    private PhoneNumberFormatter phoneNumberFormatterPL;
    private PhoneNumberFormatter phoneNumberFormatterEN;

    @Before
    public void setUp() {
        phoneNumberFormatterPL = Mockito.mock(PhoneNumberFormatterPL.class);
        phoneNumberFormatterEN = Mockito.mock(PhoneNumberFormatterEN.class);
        numberService = new NumberService(phoneNumberFormatterPL, phoneNumberFormatterEN);
    }

    @Test
    public void shouldSwitchLanguage() {
        Message message = new Message();
        message.setTitle("PL");
        numberService.languageDispatcher(message);
    }

    @Test
    public void shouldFormatWhenTitleIsPL() {
        Message message = new Message();
        message.setTitle("PL");
        message.setContent("213213");
        String number = "12321321";

        when(phoneNumberFormatterPL.format(anyString())).thenReturn("12321321");
        String formattedTextToPL = numberService.languageDispatcher(message);
        assertEquals(number, formattedTextToPL);

    }

    @Test
    public void shouldFormatWhenTitleIsEN() {
        Message message = new Message();
        message.setTitle("EN");
        message.setContent("213213");
        String number = "12321321";

        when(phoneNumberFormatterEN.format(anyString())).thenReturn("12321321");
        String formattedTextToPL = numberService.languageDispatcher(message);
        assertEquals(number, formattedTextToPL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFormatWhenTitleIsWrong() {
        Message message = new Message();
        message.setTitle("CH");
        message.setContent("213213");
        String number = "12321321";

        when(phoneNumberFormatterEN.format(anyString())).thenReturn("12321321");
        String formattedTextToPL = numberService.languageDispatcher(message);
        assertEquals(number, formattedTextToPL);
    }
}
