package mmtr.spring.dic.controller;

import mmtr.spring.dic.repository.IAction;
import mmtr.spring.dic.service.Mservices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class Mcontroller {
    private String dictionaryName;
    IAction action = new Mservices();
    private String keyValue;


    @GetMapping("/")
    public String getHome(){
        return "main";
    }

    @PostMapping("/")
    public String postHome(@RequestParam String dictionaryName) {
        this.dictionaryName = dictionaryName;
        return "menu";
    }

    @GetMapping("/menu")
    public String getMenu() {
        return "menu";
    }

    @GetMapping("/showAll")
    public void getShowAll(Model model) {
        model.addAttribute("records", action.showAllFromDic(dictionaryName));
        }

    @GetMapping("/keyForm")
    public String getKey(){
        return "keyForm";
    }

    @PostMapping("/keyForm")
    public String postKey(@ModelAttribute String keyValue) {
        this.keyValue = keyValue;
        System.out.println(keyValue);
        System.out.println(dictionaryName);
        return "searchByKey";
    }

    @GetMapping("/searchByKey")
    public String getShowByKey(Model model) throws IOException {
        System.out.println(dictionaryName);
        model.addAttribute("byKey", action.searchByKey(dictionaryName, keyValue));
        return "searchByKey";
    }
}

