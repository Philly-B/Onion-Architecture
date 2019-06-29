package de.test.onion.services;

import java.util.List;

import de.test.onion.domain.Bucket;

public interface BucketService {

	List<Bucket> getAll();

	Bucket saveBucket(Bucket bucket);

}
