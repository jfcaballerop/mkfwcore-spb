# User Service

## Resume
Microservice with MongoDB connection

## Starters

- spring-boot-starter-data-mongodb
- spring-boot-starter-web
- spring-boot-starter-tomcat -- Exclude
- spring-boot-starter-jetty
- lombok
- spring-boot-starter-test

## Features

### **Exclude Tomcat and use Jetty**

    <exclusions>
        <exclusion>
          <groupId>
              org.springframework.boot
          </groupId>
          <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
      </exclusions> 

Add Jetty

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-jetty</artifactId>
    </dependency>

### **Use MongoDB**

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>

Add *applicationConfig* class for configuration MongoDB

*@EnableMongoAuditing* let us add *created and *updated Fields in documents.

***Important!*** to use a Database is necessary point it with:

    return new MongoTemplate(mongoClient, env.getProperty("mongodb.database"));

### **ENV properties**

For security reasons is importante hide USER and PASS configuration in ConnectionString.
Note that this config is in a non public File ***env.properties***. 

This file will be inject later for Jenkins in deploy.

*Remember*: Add to .gitignore