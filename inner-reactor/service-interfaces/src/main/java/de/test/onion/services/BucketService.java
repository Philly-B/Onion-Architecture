package de.test.onion.services;

import java.util.List;

import de.test.onion.domain.Bucket;
import de.test.onion.domain.Item;

public interface BucketService {

	List<Bucket> getAll();


	Bucket saveBucket(Bucket bucket);


	void delete(String bucketId);


	Item saveItem(String bucketId, Item item);


	void deleteItem(String bucketId, String itemId);

}
