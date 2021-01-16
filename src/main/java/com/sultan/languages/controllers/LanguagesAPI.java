package com.sultan.languages.controllers;

import java.util.List;

import com.sultan.languages.models.Language;
import com.sultan.languages.services.LanguagesService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LanguagesAPI {
    
    private final LanguagesService LanguagesService;
    public LanguagesAPI(LanguagesService LanguagesService){
        this.LanguagesService = LanguagesService;
    }
    @RequestMapping("/api/languages")
    public List<Language> index() {
        return LanguagesService.allLanguages();
    }
    
    @RequestMapping(value="/api/languages", method=RequestMethod.POST)
    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") Double currentVersion) {
        Language language = new Language(name, creator, currentVersion);
        return LanguagesService.createLanguage(language);
    }
    
    @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id) {
        Language language = LanguagesService.findLanguage(id);
        return language;
    }

    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
    public Language update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") Double currentVersion) {
        Language language = LanguagesService.updateLanguage(id, name, creator, currentVersion);
        return language;
    }
    
    @RequestMapping(value="/api/languages/{id}", method = RequestMethod.DELETE)
	public void deleteOne(@PathVariable("id") Long id){
		LanguagesService.deleteLanguage(id);
	}

}
