package de.test.onion.repositories.conntectors;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.test.onion.repositories.models.DB_Bucket;

public interface DbBucketConnector extends PagingAndSortingRepository<DB_Bucket, Long> {
	// mainly auto generated
}
