package com.sultan.languages.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.sultan.languages.models.Language;
import com.sultan.languages.repositories.LanguageRepository;
@Service

public class LanguagesService {
    
        private final LanguageRepository languageRepository;
    
        public LanguagesService(LanguageRepository languageRepository) {
            this.languageRepository = languageRepository;
        }
        
        public List<Language> allLanguages() {
            return languageRepository.findAll();
        }
        
        public Language findLanguage(Long id) {
            Optional<Language> optionalLanguage = languageRepository.findById(id);
            if(optionalLanguage.isPresent()) {
                return optionalLanguage.get();
            } else {
                return null;
            }
        }
        
        public Language createLanguage(Language lang) {
            return languageRepository.save(lang);
        }
        
        public Language updateLanguage(Long id, String name, String creator, Double currentVersion) {
            if (languageRepository.findById(id).isPresent()) {
                Language lang = languageRepository.findById(id).get();
                lang.setName(name);
                lang.setCreator(creator);
                lang.setCurrentVersion(currentVersion);
                return languageRepository.save(lang);
            }
            return null;
        }
        
        public void deleteLanguage(Long id) {
            languageRepository.deleteById(id);
        }
    
        public Language editLanguage(@Valid Language language) {
            return languageRepository.save(language);
        }
    
}
