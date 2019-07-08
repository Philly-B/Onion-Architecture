package de.test.onion.repositories;

import java.util.List;

import de.test.onion.domain.Bucket;
import de.test.onion.domain.Item;

public interface BucketRepository {

	List<Bucket> findAll();


	Bucket save(Bucket bucket);


	void delete(String bucketId);


	Item saveItem(String bucketId, Item item);


	void deleteItem(String bucketId, String itemId);

}
