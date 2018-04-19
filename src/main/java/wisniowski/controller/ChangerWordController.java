package wisniowski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wisniowski.model.Message;
import wisniowski.service.ChangerWordService;

@RestController
public class ChangerWordController {

    private ChangerWordService changerWordService;

    @Autowired
    public ChangerWordController(ChangerWordService changerWordService) {
        this.changerWordService = changerWordService;
    }

    @PostMapping("/changer")
    public ResponseEntity<Message> wordChanger(@RequestBody Message msg) {
        if (validateRequest(msg) == false) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(changerWordService.replaceWrongWord(msg.getContent()), HttpStatus.OK);
    }

    private boolean validateRequest(Message msg) {
        if (msg.getContent() == null || "".equals(msg.getContent())) {
            return false;
        }
        return true;

    }
}
//example:
// "content": "Monday,Tuesday,Mittwoch"