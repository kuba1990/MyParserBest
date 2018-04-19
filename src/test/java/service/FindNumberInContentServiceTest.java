package service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wisniowski.Application;
import wisniowski.Regex.RegexConfigEN;
import wisniowski.Regex.RegexConfigPL;
import wisniowski.Regex.RegexNumber;
import wisniowski.service.FindNumberInContentService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@TestPropertySource(locations = "classpath:application.yml")
public class FindNumberInContentServiceTest {


    private RegexNumber regexConfigEN;
    private RegexNumber regexConfigPL;
    private FindNumberInContentService service;

    @Before
    public void setUp() {
        regexConfigPL = Mockito.mock(RegexConfigPL.class);
        regexConfigEN = Mockito.mock(RegexConfigEN.class);
        service = new FindNumberInContentService(regexConfigPL, regexConfigEN);
    }


    @Test
    public void shouldReturnWhenRegexPL() {
        String content = "123456789";
        when(regexConfigPL.format()).thenReturn("123456789");
        String returnedRegexPL = String.valueOf(service.getNumbers("123456789"));
        assertEquals(content, returnedRegexPL);
    }
}