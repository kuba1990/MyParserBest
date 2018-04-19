package wisniowski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wisniowski.model.Message;
import wisniowski.service.BadWordsService;

@RestController
public class BadWordsController {

    private BadWordsService badWordsService;

    @Autowired
    public BadWordsController(BadWordsService badWordsService) {
        this.badWordsService = badWordsService;
    }

    @PostMapping("/replace")
    public ResponseEntity<Message> getCensourMessage(@RequestBody Message msg) {
        if (validateRequest(msg) == false) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(badWordsService.badWordsReplacer(msg.getContent()), HttpStatus.OK);
    }

    private boolean validateRequest(Message msg) {
        if (msg.getContent() == null || "".equals(msg.getContent())) {
            return false;
        }
        return true;

    }


}

//
        /*{
        "content": "Attentiion:  kurza twarza,kurka,cholera,błyskawica Poland’s censorship machine is working "
        }*/