package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wisniowski.Application;
import wisniowski.model.Message;
import wisniowski.service.BadWordsService;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@TestPropertySource(locations = "classpath:application.yml")
public class BadWordsServiceTest {

    @Autowired
    BadWordsService badWordsService;

    @Test
    public void shouldCensorBadWord() {
        Message badWord = badWordsService.badWordsReplacer("kurka");
        assertEquals("*****", badWord.getContent());
    }

    @Test
    public void shouldNotCensorBadWord() {
        Message badWord = badWordsService.badWordsReplacer("kogut");
        assertEquals("kogut", badWord.getContent());
    }

}
