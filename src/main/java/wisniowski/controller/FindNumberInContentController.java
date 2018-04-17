package wisniowski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/numberContent")
    public List <String> getContent(@RequestBody Message msg){

       return findNumberInContentService.getNumbers(msg.getContent());

    }
}

