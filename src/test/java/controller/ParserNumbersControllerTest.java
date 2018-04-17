package controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import wisniowski.Application;
import wisniowski.controller.ChangerWordController;
import wisniowski.controller.ParserNumbersController;
import wisniowski.model.Message;
import wisniowski.service.ChangerWordService;
import wisniowski.service.NumberService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})

public class ParserNumbersControllerTest {

    private static final String HTTP_LOCALHOST = "http://localhost";
    private static final String TITLE = "title";
    private static final String CONTENT = "content";
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    private ParserNumbersController controller;
    private NumberService service;



    @Before
    public void init() {
        service = Mockito.mock(NumberService.class);
        controller = new ParserNumbersController(service);
    }


    @Test
    public void shouldVerifyMessage() {
        Message msg = new Message();
        msg.setTitle("PL");
        msg.setContent("123456789");

        assertThat(restTemplate.postForObject(localhostWithPort("numberFormatter"), msg, Message.class)).hasFieldOrProperty(TITLE).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldIllegalArgumentExceptionWhenNumberOfDigitLowerThan9() {
        Message  msg = new Message();
        msg.setContent("123");
        msg.setTitle("PL");
        msg.setRegex(null);
        controller.wordChanger(msg);

    }



    private String localhostWithPort(String path) {
        return HTTP_LOCALHOST + ":" + port + "/" + path;
    }
}
