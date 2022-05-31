package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/main")
public class firstController {


    Logger log= LoggerFactory.getLogger(firstController.class);

    /**/

/** 2 ways to let the spring boot notify about the type of request
 * 1. old way : @RequestMapping
 * 2. Specific type annotation: @GETMapping,@PostMapping..
 * */

/**There are 2 ways to read Get param,
 * One is via request parameter
 *  ex: abc.com?name=<VALUE>
 *  Two is via URL value
 *  ex: abc.com/<VALUE>/
 *
 * */


    @GetMapping("/greet1")
    public String greetMyUser1(@RequestParam("name") String name){
        return "Hello " + name +"!!!";
    }

    @GetMapping("/greet/{name}")
    public String greetMyUser(@PathVariable("name") String name){
        return "Hello " + name +"!!!";
    }


  /*
   old way

   @RequestMapping(value="/greeting",method= RequestMethod.GET)
    public String greet2(){
        return "Hi User!!";
    }*/




}
/**
 * for all the APIs steps:
 *
 *  Types of API:
 https://apisyouwonthate.com/blog/understanding-rpc-rest-and-graphql
 *
 * 1. Finalize the contract (example: swagger)
 *      a. rest endpoint
 *      b. http method
 *      c. status codes
 *      d. exceptions, error message or redirections
 * */

/**
 * 127.0.0.1:8080 --> locahost
 *
 * REST - stateless
 *   Ex: 1 ( Stateful example)
 *   abc.com/records  --> 1 - 10 (100)
 *   abc.com/records  -->10 - 20 (100)
 *   abc.com/records --> 20- 30
 *
 *   Ex:2 (Stateless example)
 *   abc.com/records?start=0&end=10  --> 1 - 10 (100)
 *   abc.com/records?start=10&end=20  --> 10 - 20 (100)
 *
 *
 *
 * */


/**
 *  1.GET  --> retrieve the information from the server.uses the URL to send the data or input
 *  2.POST --> create a new resource in the system.
 *  3.DELETE --> Delete or remove a resource from the system
 *  4.PUT   --> update an attribute of the resource.
 *  5.PATCH --> update an attribute of the resource.
 *  OPTIONS,HEAD, TRACE..
 *
 *  1. safety ( state changes in the resource)  2. Idempotent -> no unwanted change
 *
 *  GET/OPTIONS/HEAD ->    Safe, Idempotent
 *  POST ->   Unsafe, yes/no
 *  DELETE -> Unsafe, Idempotent  Example: (delete student roll no. 1) (15 times)
 *  PUT  -> Unsafe, non-Idempotent Example: (Rolln0.2 age:10)
 *  PATCH -> Unsafe, Idempotent
 *
 *
 *  Student:roll no.1, name: amit
 *  put --> change the roll no, 1 to 2
 *  patch --> add new attribute
 *          roll no.1, name: amit, lastname: sharma
 *
 * **/

/**
 * Status code:
 *
 * link: https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
 * */


/**
 * Types of logger
 *
 *  1.Trace ->
 *  2.Debug
 *  3.Info
 *  4.Warn
 *  5.Error
 *
 * */






