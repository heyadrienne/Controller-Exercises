package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, String language){
        if (Objects.equals(language, "English")) {
            return "Hello, " + name + "!";
        } if (Objects.equals(language, "Spanish")) {
            return "Hola, " + name + "!";
        } if (Objects.equals(language, "French")) {
            return "Bonjour, " + name + "!";
        } if (Objects.equals(language, "German")) {
            return "Hallo, " + name + "!";
        } if (Objects.equals(language, "Italian")) {
            return "Ciao, " + name + "!";
        } else {
            return "Error";
        }
    }

    //Handles request of the form /hello/LaunchCode

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value ='English'>English</option>" +
                "<option value ='Spanish'>Spanish</option>" +
                "<option value ='French'>French</option>" +
                "<option value ='German'>German</option>" +
                "<option value ='Italian'>Italian</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


}
