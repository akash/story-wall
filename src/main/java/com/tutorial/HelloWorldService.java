package com.tutorial;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.tutorial.core.Saying;
import com.tutorial.core.Story;
import com.tutorial.health.MongoHealthCheck;
import com.tutorial.repository.MongoSayingRepository;
import com.tutorial.resource.HelloWorldResource;
import com.tutorial.resource.StoryResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.bundles.AssetsBundle;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;
import net.vz.mongodb.jackson.JacksonDBCollection;

public class HelloWorldService extends Service<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldService().run(args);
    }

    public HelloWorldService() {
        super("hello-world");
        addBundle(new ViewBundle());
        addBundle(new AssetsBundle("/assets/"));
    }

    @Override
    public void initialize(HelloWorldConfiguration configuration, Environment environment) throws Exception {
        Mongo mongo = new Mongo(configuration.mongohost, configuration.mongoport);
        DB db = mongo.getDB(configuration.mongodb);
        MongoManaged mongoManaged = new MongoManaged(mongo);
        environment.manage(mongoManaged);
        environment.addHealthCheck(new MongoHealthCheck(mongo));

        JacksonDBCollection<Saying, String> sayings = JacksonDBCollection.wrap(db.getCollection("sayings"), Saying.class, String.class);
        if (sayings.find().count() == 0)
            sayings.insert(new Saying("Hello %s", "en"));

        environment.addResource(new HelloWorldResource(new MongoSayingRepository(sayings)));

        JacksonDBCollection<Story, String> stories = JacksonDBCollection.wrap(db.getCollection("stories"), Story.class, String.class);
        environment.addResource(new StoryResource(stories));
    }

}