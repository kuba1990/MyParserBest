package wisniowski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wisniowski.model.Message;
import wisniowski.service.NumberService;

@RestController
public class ParserNumbersController {

    private NumberService numberService;

    @Autowired
    public ParserNumbersController(NumberService numberService) {
        this.numberService = numberService;
    }

    @PostMapping("/numberFormatter")
    public ResponseEntity<Message> wordChanger(@RequestBody Message msg) {
        if (validateRequest(msg) == false || validateReqeustByCountry(msg)==false ) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        if(msg.getContent().length() < 9){
            throw new IllegalArgumentException("number should contains 9 digits");
        }
        return new ResponseEntity(new Message(msg.getTitle(), numberService.languageDispatcher(msg), msg.getRegex()), HttpStatus.OK);
    }

    private boolean validateRequest(Message msg) {
        if (msg.getContent() == null || "".equals(msg.getContent())) {
            return false;
        }
        return true;

    }
    private boolean validateReqeustByCountry(Message msg) {
        if (msg.getTitle().equals("PL") || msg.getTitle().equals("EN")) {
            return true;
        }
        return false;
    }
}