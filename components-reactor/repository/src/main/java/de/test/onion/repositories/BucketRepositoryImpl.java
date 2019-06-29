package de.test.onion.repositories;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import de.test.onion.domain.Bucket;
import de.test.onion.repositories.common.RepositoryService;
import de.test.onion.repositories.conntectors.DbBucketConnector;
import de.test.onion.repositories.mappers.BucketMapper;
import de.test.onion.repositories.models.DbBucket;
import lombok.RequiredArgsConstructor;

@RepositoryService
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BucketRepositoryImpl implements BucketRepository {

	private final DbBucketConnector dbBucketConnector;
	private final BucketMapper bucketMapper;

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

}
