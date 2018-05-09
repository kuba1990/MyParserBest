package wisniowski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wisniowski.model.Message;
import wisniowski.service.FindNumberInContentService;

import java.util.List;

@RestController
public class FindNumberInContentController {

    @Autowired
    private FindNumberInContentService findNumberInContentService;

    public FindNumberInContentController(FindNumberInContentService findNumberInContentService) {
        this.findNumberInContentService = findNumberInContentService;
    }

    @PostMapping("/numberContent")
    public List<String> getContent(@RequestBody Message msg) {
        if (validateRequest(msg) == true) {
            return findNumberInContentService.getNumbers(msg.getContent());
        } else {
            throw (new IllegalArgumentException());
        }
    }

    private boolean validateRequest(Message msg) {
        if (msg.getContent() == null || "".equals(msg.getContent())) {
            return false;
        }
        return true;

    }

}

//example request:
       /* {
        "content": "call me on (703)111-2121 or call me on 123456789"
        }*/

