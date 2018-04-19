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
import wisniowski.model.Message;
import wisniowski.service.ChangerWordService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class ChangeWordControllerTest {

    private ChangerWordService changerWordServiceMock;
    private ChangerWordController controller;

    private static final String HTTP_LOCALHOST = "http://localhost";
    private static final String TITLE = "title";
    private static final String CONTENT = "content";
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void init() {
        changerWordServiceMock = Mockito.mock(ChangerWordService.class);
        controller = new ChangerWordController(changerWordServiceMock);
    }

    @Test
    public void shouldResponseBadRequest() {
        Message msg = new Message();
        msg.setTitle("title");
        assertThat(restTemplate.postForEntity(localhostWithPort("changer"), msg, Message.class).getStatusCode()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);

    }

    private String localhostWithPort(String path) {
        return HTTP_LOCALHOST + ":" + port + "/" + path;
    }


    @Test
    public void shouldCensourMessage() {
        Message message = new Message();
        message.setContent("blabla");
        controller.wordChanger(message);
        Mockito.verify(changerWordServiceMock).replaceWrongWord("blabla");

    }
}


