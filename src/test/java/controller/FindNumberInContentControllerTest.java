package controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wisniowski.Application;
import wisniowski.controller.FindNumberInContentController;
import wisniowski.model.Message;
import wisniowski.service.FindNumberInContentService;


@RunWith(SpringRunner.class)
@SpringBootTest(/*webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,*/ classes = {Application.class})
public class FindNumberInContentControllerTest {

    private FindNumberInContentService findNumberInContentServiceMock;
    private FindNumberInContentController controller;

    @Before
    public void init() {
        findNumberInContentServiceMock = Mockito.mock(FindNumberInContentService.class);
        controller = new FindNumberInContentController(findNumberInContentServiceMock);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldIllegalArgumentExceptionWhenContentNull() {
        Message msg = new Message();
        msg.setContent("");
        controller.getContent(msg);

    }
}
