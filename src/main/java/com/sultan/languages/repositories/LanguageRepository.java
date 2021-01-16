package com.sultan.languages.repositories;

import java.util.List;

import com.sultan.languages.models.Language;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LanguageRepository extends CrudRepository<Language, Long> {
    
    List<Language> findAll();
}
