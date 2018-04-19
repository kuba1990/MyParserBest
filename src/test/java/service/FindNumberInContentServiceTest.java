/*
package service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wisniowski.Application;
import wisniowski.Regex.RegexConfigEN;
import wisniowski.Regex.RegexConfigPL;
import wisniowski.Regex.RegexNumber;
import wisniowski.model.Message;
import wisniowski.service.FindNumberInContentService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@TestPropertySource(locations = "classpath:application.yml")
public class FindNumberInContentServiceTest {

    @Autowired
    private FindNumberInContentService service;
    private RegexNumber regexConfigEN;
    private RegexNumber regexConfigPL;

    @Before
    public void setUp() {
        regexConfigPL = Mockito.mock(RegexConfigPL.class);
        regexConfigEN = Mockito.mock(RegexConfigEN.class);
        service = new FindNumberInContentService(regexConfigPL, regexConfigEN);
    }


    @Test
    public void shouldFormatWhenTitleIsPL() {
        String number = "12321321";
        service.getNumbers("123456789");

    }
}*/
