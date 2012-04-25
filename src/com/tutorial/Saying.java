package com.tutorial;

import com.google.common.base.Optional;

import javax.persistence.Id;

public class Saying {
    @Id
    private String id;
    private String template;
    private String lang;

    public Saying(){

    }

    public Saying(String id, String template, String lang) {
        this.id = id;
        this.template = template;
        this.lang = lang;
    }

    public String getId() {
        return id;
    }

    public String getTemplate() {
        return template;
    }

    public String getLang() {
        return lang;
    }

    public Saying apply(Optional<String> name) {
        return new Saying(this.id, String.format(template, name.or("Stranger")), lang);
    }
}