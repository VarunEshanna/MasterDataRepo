package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.annotation.ComponentScan;

@Controller
@SpringBootApplication
@ComponentScan(basePackages = "com.adobe")
public class Main {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);
  }

  @RequestMapping("/")
  String index() {
    return "index";
  }

  @RequestMapping("/voice")
  String voice() {
    return "voice";
  }

  @RequestMapping("/config")
  String geta() {
    return "a";
  }

  @RequestMapping("/setup")
  String setup() {
    return "setup";
  }

  @RequestMapping("/login")
  String login() {
    return "login";
  }

}
