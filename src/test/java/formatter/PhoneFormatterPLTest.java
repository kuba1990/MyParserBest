package formatter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wisniowski.Application;
import wisniowski.configuration.PatternConfig;
import wisniowski.formatter.PhoneNumberFormatterPL;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@TestPropertySource(locations = "classpath:application.yml")
public class PhoneFormatterPLTest {

    @Autowired
    private PhoneNumberFormatterPL phoneNumberFormatterPL;

    @Autowired
    private PatternConfig patternConfig;


    @Before
    public void setUp() {
        patternConfig = Mockito.mock(PatternConfig.class);
        phoneNumberFormatterPL = new PhoneNumberFormatterPL(patternConfig);
    }

    @Test
    public void shouldReturnFormattedNumber() {

        List<String> patterns = new ArrayList<>();
        patterns.add("(\\d{3})(\\d{3})(\\d{3})");
        patterns.add("(\\d{2})(\\d{3})(\\d{4})");


        when(patternConfig.getPatterns()).thenReturn(patterns);

        String formattedNumber = phoneNumberFormatterPL.format("878927299");
        assertEquals("(+48)87-892-7299", formattedNumber);
    }
}
