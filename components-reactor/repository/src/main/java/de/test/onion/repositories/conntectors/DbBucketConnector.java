package de.test.onion.repositories.conntectors;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.test.onion.repositories.common.DBConnector;
import de.test.onion.repositories.models.DbBucket;

@DBConnector
public interface DbBucketConnector extends MongoRepository<DbBucket, String> {
	// mainly auto generated
}
