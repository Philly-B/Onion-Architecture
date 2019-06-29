package de.test.onion.repositories.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import de.test.onion.domain.Bucket;
import de.test.onion.domain.Item;
import de.test.onion.domain.common.Mapper;
import de.test.onion.repositories.models.DbBucket;
import de.test.onion.repositories.models.DbItem;

@Mapper
public class BucketMapper {

	@Autowired
	private ItemMapper itemMapper;

	public DbBucket mapToDB_Bucket(Bucket bucket) {

		List<DbItem> db_items = bucket.getItems().stream().map(this.itemMapper::mapToDbItem)
				.collect(Collectors.toList());

		return new DbBucket(bucket.getId(), bucket.getName(), db_items);
	}

	public Bucket mapToBucket(DbBucket dbBucket) {

		List<Item> items = dbBucket.getItems().stream().map(this.itemMapper::mapToItem).collect(Collectors.toList());

		return new Bucket(dbBucket.getId(), dbBucket.getName(), items);
	}

}
