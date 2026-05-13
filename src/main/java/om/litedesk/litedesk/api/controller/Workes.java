package om.litedesk.litedesk.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/work")


public class Workes {

    @GetMapping
    public String greeting(){
        return"hello team agile oracle";
    }

    @PostMapping(path="/{id}")
    public String nam(@PathVariable String id){
        return"hello "+id;
    }

}
