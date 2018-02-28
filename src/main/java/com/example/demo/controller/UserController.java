package com.example.demo.controller;

import com.example.demo.beans.TransformedWord;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

  @RequestMapping(
    value = "/transform",
    method = RequestMethod.GET,
    produces = "application/json"
  )
  @CrossOrigin(origins = "http://localhost:4200")
  public TransformedWord sayAWord(@RequestParam(value= "inputToken")int inputToken){
    String name = "";
    boolean modThree = inputToken%3 ==0;
    boolean modFive = inputToken%5 == 0;
    if(modThree && modFive )
    {
      name = "FizzBuzz";
    }
    else if(modThree){
      name = "Fizz";
    }
    else if(modFive){
      name = "Buzz";
    }
    else{
      //convert integer to String
      name = Integer.toString(inputToken);
    }
    return new TransformedWord(name);
  }
}
