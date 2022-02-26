package com.mrknight.core.services.usersvc.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@EnableMongoAuditing
@PropertySource(ignoreResourceNotFound = true, value = "classpath:env.properties")
public class applicationConfig {

  @Autowired
  private Environment env;

  @Bean
  public MongoClient mongoClient() {

    ConnectionString connectionString = new ConnectionString(env.getProperty("mongodb.uri"));
    MongoClientSettings settings = MongoClientSettings.builder()
        .applyConnectionString(connectionString)
        .serverApi(ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build())
        .build();
    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase(env.getProperty("mongodb.database"));

    System.out.println("*** Database connect: " + database.getName());

    return mongoClient;
  }

  @Bean
  public MongoTemplate mongoTemplate() {
    MongoClient mongoClient = mongoClient();
    return new MongoTemplate(mongoClient, env.getProperty("mongodb.database"));
  }

}
