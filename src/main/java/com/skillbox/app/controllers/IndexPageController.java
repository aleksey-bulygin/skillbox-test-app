package com.skillbox.app.controllers;

import com.skillbox.app.models.TextContainer;
import com.skillbox.app.service.TextDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class IndexPageController {

    private final TextDataService dataService;

    @Autowired
    public IndexPageController(TextDataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveText(@ModelAttribute TextContainer textContainer,
                                  Map<String, Object> model){
        boolean isValidText = dataService.isCorrectText(textContainer.getText());
        model.put("isValidText", isValidText);

        if (isValidText) {
            dataService.save(textContainer);
            return "redirect:/";
        }

        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        model.put("textContainer", new TextContainer());
        return "index";
    }
}
