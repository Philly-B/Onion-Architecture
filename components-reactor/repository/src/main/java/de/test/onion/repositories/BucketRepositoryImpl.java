package de.test.onion.repositories;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import de.test.onion.domain.Bucket;
import de.test.onion.domain.Item;
import de.test.onion.domain.exceptions.DuplicateObjectException;
import de.test.onion.domain.exceptions.ObjectDoesNotExistException;
import de.test.onion.repositories.common.RepositoryService;
import de.test.onion.repositories.conntectors.DbBucketConnector;
import de.test.onion.repositories.mappers.BucketMapper;
import de.test.onion.repositories.mappers.ItemMapper;
import de.test.onion.repositories.models.DbBucket;
import de.test.onion.repositories.models.DbItem;
import lombok.RequiredArgsConstructor;

@RepositoryService
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BucketRepositoryImpl implements BucketRepository {

	private final DbBucketConnector dbBucketConnector;
	private final BucketMapper bucketMapper;
	private final ItemMapper itemMapper;


	@Override
	public List<Bucket> findAll() {

		return StreamSupport.stream(this.dbBucketConnector.findAll().spliterator(), false).distinct()
				.map(this.bucketMapper::mapToBucket).collect(Collectors.toList());
	}


	@Override
	public Bucket save(Bucket bucket) {

		DbBucket dbBucket = this.bucketMapper.mapToDB_Bucket(bucket);
		DbBucket savedDBBucket = this.dbBucketConnector.save(dbBucket);
		return this.bucketMapper.mapToBucket(savedDBBucket);
	}


	@Override
	public void delete(String bucketId) {

		this.dbBucketConnector.findById(bucketId).ifPresent(this.dbBucketConnector::delete);
	}


	@Override
	public Item saveItem(String bucketId, Item item) {

		DbBucket bucket = this.dbBucketConnector.findById(bucketId)
				.orElseThrow(() -> new ObjectDoesNotExistException("No object found for id " + bucketId));
		DbItem dbItem = this.itemMapper.mapToDbItem(item);
		this.assertItemDoesNotAlreadyExist(bucket, dbItem);

		if (item.getId() == null) {
			this.createItem(bucket, dbItem);
		} else {
			this.updateItem(bucket, dbItem);
		}

		return this.dbBucketConnector.save(bucket)
				.getItems()
				.stream()
				.filter(i -> dbItem.getName().equals(i.getName()))
				.findFirst()
				.map(this.itemMapper::mapToItem)
				.orElseThrow(() -> new ObjectDoesNotExistException("Something went wrong when saving"));
	}


	private void updateItem(DbBucket bucket, DbItem item) {

		DbItem dbItem = bucket.getItems()
				.stream()
				.filter(i -> i.getId().equals(item.getId()))
				.findFirst()
				.orElseThrow(() -> new ObjectDoesNotExistException("There is no item for id " + item.getId()));

		dbItem.setName(item.getName());
		dbItem.setValue(item.getValue());
	}


	private void createItem(DbBucket bucket, DbItem dbItem) {

		dbItem.setId(new ObjectId().toString());
		bucket.getItems().add(dbItem);
	}


	private void assertItemDoesNotAlreadyExist(DbBucket bucket, DbItem dbItem) {

		boolean itemAlreadyExists = bucket.getItems().stream().map(DbItem::getName).anyMatch(n -> n.equals(dbItem.getName()));
		if (itemAlreadyExists) {
			throw new DuplicateObjectException("There is already an item with the name " + dbItem.getName());
		}
	}


	@Override
	public void deleteItem(String bucketId, String itemId) {

		DbBucket bucket = this.dbBucketConnector.findById(bucketId)
				.orElseThrow(() -> new ObjectDoesNotExistException("No object found for id " + bucketId));

		bucket.getItems().removeIf(i -> i.getId().equals(itemId));

		this.dbBucketConnector.save(bucket);
	}

}
