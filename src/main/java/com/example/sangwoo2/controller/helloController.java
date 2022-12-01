package com.example.sangwoo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
  
  @GetMapping("hello")
  public String hello(Model model) {
    model.addAttribute("data", "spring!!!!");
    return "hello";
    // Controller에서 ViewResolver가 /templates 밑에 return + .html 위치를 mappin한다
  }

  @GetMapping("hello-mvc")
  public String helloMVC(@RequestParam("name") String name, Model model) {
    model.addAttribute("name", name);
    return "hello-template";
  }

  @GetMapping("hello-spring")
  @ResponseBody // Http의 Header부와 Body부에서 body부에 return 데이터를 직접 넣어주겠다.
  // view 이런거 없이 hello + 입력한 문자가 그대로 출력됨 (String Converter)
  public String helloString(@RequestParam("name") String name) {
    return "hello " + name;
  }
  
  @GetMapping("hello-api")
  @ResponseBody
  public Hello helloAPI(@RequestParam("name") String name) {
    Hello hello = new Hello();
    hello.setName(name);
    return hello; // 문자를 반환하는게 아니라 객체를 반환하니까! 다르게 작동한다. -> JSON 방식으로 Http 응답에 반환한다.(Json Converter)
  }

  static class Hello {
    // 자바 빈 규약. class 내에서만 쓸 수 있는데 Hello 클래스 내부에 name이라는 컴포넌트가 있으니까
    // Getter Setter로만 사용할 수 있다.
      private String name;

      public String getName() {
        return name;
      }

      public void setName(String name) {
        this.name = name;
      }
    }
  }
  
