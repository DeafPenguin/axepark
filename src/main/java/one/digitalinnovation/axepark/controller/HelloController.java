package one.digitalinnovation.axepark.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Tag(name= "Hello Controller")
public class HelloController {

    @GetMapping
    public String hello(){
        return "Hello, if you're Luana and are reading this... Remember, I always love you no matter what!";
    }
}
