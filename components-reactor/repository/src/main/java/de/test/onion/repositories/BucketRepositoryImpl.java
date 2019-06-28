package de.test.onion.repositories;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.test.onion.domain.Bucket;
import de.test.onion.repositories.conntectors.DbBucketConnector;
import de.test.onion.repositories.mappers.BucketMapper;
import de.test.onion.repositories.models.DB_Bucket;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BucketRepositoryImpl implements BucketRepository {

	private final DbBucketConnector dbBucketConnector;
	private final BucketMapper bucketMapper;


	@Override
	public List<Bucket> findAll() {

		return StreamSupport.stream(this.dbBucketConnector.findAll().spliterator(), false)
				.distinct()
				.map(this.bucketMapper::mapToBucket)
				.collect(Collectors.toList());
	}


	public Bucket save(Bucket bucket) {

		DB_Bucket dB_Bucket = this.bucketMapper.mapToDB_Bucket(bucket);
		DB_Bucket savedDBBucket = this.dbBucketConnector.save(dB_Bucket);
		return this.bucketMapper.mapToBucket(savedDBBucket);
	}

}
