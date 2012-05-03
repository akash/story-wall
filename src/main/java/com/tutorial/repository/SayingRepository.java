package com.tutorial.repository;

import com.tutorial.core.Saying;

public interface SayingRepository {
    Saying findByLanguage(String language);
}
