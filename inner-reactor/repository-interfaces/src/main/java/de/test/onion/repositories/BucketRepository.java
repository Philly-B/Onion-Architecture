package de.test.onion.repositories;

import java.util.List;

import de.test.onion.domain.Bucket;

public interface BucketRepository {

	List<Bucket> findAll();

	Bucket save(Bucket bucket);

}
