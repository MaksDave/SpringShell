package ru.maksdave.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/banana")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name",required = false) String name, @RequestParam(value = "surname",required = false)String surname, Model model){
        /*String name = request.getParameter("name");
        String surname = request.getParameter("surname");*/
        /*System.out.println("Hello " + name + " " + surname);
        System.out.println();*/
        model.addAttribute("message","Hello "+ name + " " + surname);
        System.out.printf("hellouer %s %s",name,surname);
        return "first/hello";

    }
    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

    @GetMapping("/helloworld")
    public String helloWorld(){
        return "hello_world";
    }

    @GetMapping("/calculator")
    public String calcPage(@RequestParam(value = "action",required = false) String action,@RequestParam(value = "a",required = true)Integer a,@RequestParam(value = "b",required = true)Integer b,Model model){
        double result = 0;
        switch(action){
            case "multiplication": if(a!=0&&b!=0){result =a*(double)b;
            }else{action="Illegal action attempt!";
            }
                break;
            case "addition": result =a+b; break;
            case "subtraction": result =a-b; break;
            case "division":  if(a!=0&&b!=0){result=a/(double)b;
            }else{action="Illegal action attempt!";
            }
                break;
            default: action="No operation chosen...";
                break;
        }
        model.addAttribute("actionDone",action);
        model.addAttribute("resultAchieved", result);
        return "first/calc";
    }
}
