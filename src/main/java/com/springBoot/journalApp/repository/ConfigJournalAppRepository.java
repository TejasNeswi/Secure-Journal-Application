package com.springBoot.journalApp.repository;


import com.springBoot.journalApp.entity.ConfigJournalAppEntity;
import com.springBoot.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {


}
