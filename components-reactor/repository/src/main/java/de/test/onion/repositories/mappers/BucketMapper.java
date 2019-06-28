package de.test.onion.repositories.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.test.onion.domain.Bucket;
import de.test.onion.domain.Item;
import de.test.onion.repositories.models.DB_Bucket;
import de.test.onion.repositories.models.DB_Item;

@Component
public class BucketMapper {

	@Autowired
	private ItemMapper itemMapper;


	public DB_Bucket mapToDB_Bucket(Bucket bucket) {

		List<DB_Item> db_items = bucket.getItems()
				.stream()
				.map(this.itemMapper::mapToDB_Item)
				.collect(Collectors.toList());

		return new DB_Bucket(bucket.getId(), bucket.getName(), db_items);
	}


	public Bucket mapToBucket(DB_Bucket db_bucket) {

		List<Item> items = db_bucket.getItems()
				.stream()
				.map(this.itemMapper::mapToItem)
				.collect(Collectors.toList());

		return new Bucket(db_bucket.getId(), db_bucket.getName(), items);
	}

}
