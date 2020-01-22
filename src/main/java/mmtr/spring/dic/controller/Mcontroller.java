package mmtr.spring.dic.controller;

import mmtr.spring.dic.repository.IAction;
import mmtr.spring.dic.service.Mservices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class Mcontroller {
    private String dictionaryName;
    private String keyValue;
    IAction action = new Mservices();

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

    @PostMapping("/searchByKey")
    public String searchByKey(@RequestParam("keyValue") String keyValue, Model model) throws IOException {
        this.keyValue = keyValue;
        model.addAttribute("byKey", action.searchByKey(dictionaryName, keyValue));
        return "searchByKey";
    }

    @GetMapping("/removeKeyForm")
    public String getRemoveKey(){
        return "removeKeyForm";
    }

    @PostMapping("/removeValue")
    public String removeFromFileByKey(@RequestParam("keyValue") String keyValue, Model model) throws IOException {
        this.keyValue = keyValue;
        model.addAttribute("removeV", action.removeFromFile(dictionaryName, keyValue));
        return "removeValue";
    }


}

