package com.competition.hunter.aichatting.config;

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories(basePackages = ["com.competition.hunter.aichatting.repository.mongo"])
class MongoConfig : AbstractMongoClientConfiguration() {

    override fun getDatabaseName(): String {
        return "mongo"
    }

    override fun mongoClient(): MongoClient {
        var connect = ConnectionString("mongodb://localhost:27017/hunter?authSource=admin")
        return MongoClients
            .create(
                MongoClientSettings
                    .builder()
                    .applyConnectionString(connect)
                    .build()
            )
    }

}
