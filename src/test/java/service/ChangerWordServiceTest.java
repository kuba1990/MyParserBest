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
import wisniowski.configuration.DaysConfig;
import wisniowski.service.ChangerWordService;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class) @ContextConfiguration(classes = {Application.class})
@TestPropertySource(locations="classpath:application.yml")
public class ChangerWordServiceTest {

    @Autowired
    private ChangerWordService changerWordService;

    private DaysConfig daysConfig;

    @Before
    public void setUp() {
        daysConfig = Mockito.mock(DaysConfig.class);
        changerWordService = new ChangerWordService(daysConfig);
    }

    @Test
    public void shouldNotChangeWord(){
        String replacedContent = changerWordService.replaceWrongWord("bla");
        assertEquals("bla", replacedContent);
    }

}
