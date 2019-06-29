package de.test.onion.repositories.conntectors;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.test.onion.repositories.common.DBConnector;
import de.test.onion.repositories.models.DbBucket;

@DBConnector
public interface DbBucketConnector extends PagingAndSortingRepository<DbBucket, Long> {
	// mainly auto generated
}
