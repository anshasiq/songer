package com.example.songr ;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Allreq {


//    @Override
//    @RequestMapping("homepage")
    @GetMapping("/hi")
    @ResponseBody
    public String Code() {
   return "hi it's me";
    }
    @GetMapping("/hello")
    public String renderAPage(Model viewName){
        viewName.addAttribute("name","Ahmad");
        return "hello.html";
    }

    @GetMapping("/capitalize/{cookieName}")
    public String capitalize(Model m , @PathVariable String cookieName) {
        String name=cookieName;
        m.addAttribute("name",name.toUpperCase());
        return "hello.html";
    }
    @GetMapping("/albums")
    public String albums(Model albmusModel){
        Album album1 = new Album("Born to die","Lana del rey",9,180,"https://i.pinimg.com/564x/34/32/93/3432934519d074a56031263185e405a9.jpg");
        Album album2 = new Album("The Eminem Show" , "Eminem",19 ,4260,"https://i.pinimg.com/564x/07/13/9c/07139c5c7253898b88652e97c3604466.jpg");
        Album album3 = new Album("This Is Acting" , "Sia" , 18,4230,"https://i.pinimg.com/564x/0a/b9/3a/0ab93a940574edcb06814837533905d2.jpg");
        albmusModel.addAttribute("albums",new Album[]{album1,album2,album3});
        return "album.html";
    }
    @GetMapping("")
    @ResponseBody
    public String albums(){
      return "Home page";
    }
}
