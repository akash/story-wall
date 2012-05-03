package com.tutorial;

import com.yammer.dropwizard.config.Configuration;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class HelloWorldConfiguration extends Configuration {
    @JsonProperty @NotEmpty
    public String mongohost = "localhost";

    @Min(1)
    @Max(65535)
    @JsonProperty
    public int mongoport = 27017;

    @JsonProperty @NotEmpty
    public String mongodb = "yourdb";
}
