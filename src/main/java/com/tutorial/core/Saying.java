package com.tutorial.core;

import com.google.common.base.Optional;
import net.vz.mongodb.jackson.Id;

import javax.persistence.GeneratedValue;


public class Saying {

    @Id @GeneratedValue
    private String id;
    private String template;
    private String lang;

    public Saying(){ }

    public Saying(String template, String lang) {
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

    public String apply(Optional<String> name) {
        return String.format(template, name.or("Stranger"));
    }
}