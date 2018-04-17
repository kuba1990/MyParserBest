package formatter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import wisniowski.configuration.PatternConfig;
import wisniowski.formatter.PhoneNumberFormatterEN;
import wisniowski.formatter.PhoneNumberFormatterPL;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PhoneFormatterENTest {

    @Autowired
    private PhoneNumberFormatterEN phoneNumberFormatterEN;

    @Autowired
    private PatternConfig patternConfig;


    @Before
    public void setUp() {
        patternConfig = Mockito.mock(PatternConfig.class);
        phoneNumberFormatterEN = new PhoneNumberFormatterEN(patternConfig);
    }

    @Test
    public void shouldReturnFormattedNumberEN() {
        List<String> patterns = new ArrayList<>();
        patterns.add("(\\d{3})(\\d{3})(\\d{3})");
        patterns.add("(\\d{2})(\\d{3})(\\d{4})");
        when(patternConfig.getPatterns()).thenReturn(patterns);
        String formattedNumber = phoneNumberFormatterEN.format("123456789");
        assertEquals("(+44)123-456-789", formattedNumber);
    }
}
