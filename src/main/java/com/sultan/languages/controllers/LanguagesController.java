package com.sultan.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import com.sultan.languages.models.Language;
import com.sultan.languages.services.LanguagesService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class LanguagesController {
    
    private final LanguagesService languagesService;
    
    public LanguagesController(LanguagesService languagesService) {
        this.languagesService = languagesService;
    }

    @RequestMapping("/")
	public String index() {
		return "redirect:/languages";
	}
    
    @RequestMapping("/languages")
    public String index(Model model) {
        List<Language> languages = languagesService.allLanguages();
        model.addAttribute("languages", languages);
        return "/languages/index.jsp";
    }

    @RequestMapping("/languages/new")
    public String newLanguage(@ModelAttribute("language") Language language) {
        return "/languages/new.jsp";
    }

    @RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/new.jsp";
        } else {
            languagesService.createLanguage(language);
            return "redirect:/languages";
        }
    }

    @RequestMapping("/languages/{id}")
    public String displayOne(@PathVariable("id") Long id, Model model) {
        Language selected_language = languagesService.findLanguage(id);
        model.addAttribute("selected_language", selected_language);
        
        return "/languages/show.jsp";
    }

    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languagesService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
            languagesService.editLanguage(language);
            return "redirect:/languages";
        }
    }

    @RequestMapping(value="/languages/{id}/delete", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languagesService.deleteLanguage(id);
        return "redirect:/languages";
    }


}
