package de.test.onion.repositories;

import static org.junit.Assert.*;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.easymock.EasyMock.*;

import de.test.onion.domain.Bucket;
import de.test.onion.domain.common.AbstractCommonTest;
import de.test.onion.domain.mothers.BucketMother;
import de.test.onion.domain.mothers.BucketMother.BUCKET_NAME;
import de.test.onion.repositories.conntectors.DbBucketConnector;
import de.test.onion.repositories.mappers.BucketMapper;
import de.test.onion.repositories.models.DbBucket;
import de.test.onion.repositories.mothers.DbBucketMother;
import de.test.onion.repositories.mothers.DbBucketMother.DB_BUCKET_NAME;
import de.test.onion.utils.IterableHelper;

public class BucketRepositoryImplTest extends AbstractCommonTest {

	private BucketRepositoryImpl bucketRepositoryImpl;

	private final DbBucketConnector dbBucketConnector = this.createMock(DbBucketConnector.class);
	private final BucketMapper bucketMapper = this.createMock(BucketMapper.class);

	private final DbBucketMother dbBucketMother = this.createMother(DbBucketMother.class);
	private final BucketMother bucketMother = this.createMother(BucketMother.class);

	@Override
	public void initialize() {

		bucketRepositoryImpl = new BucketRepositoryImpl(dbBucketConnector, bucketMapper);

	}

	@Test
	public void testFindAll() {

		DbBucket dbBucket1 = dbBucketMother.generate(DB_BUCKET_NAME.GERMANY);
		Bucket bucket1 = bucketMother.generate(BUCKET_NAME.GERMANY);
		DbBucket dbBucket2 = dbBucketMother.generate(DB_BUCKET_NAME.USA);
		Bucket bucket2 = bucketMother.generate(BUCKET_NAME.USA);
		Iterable<DbBucket> iterableResult = IterableHelper.convertToIterable(dbBucket1, dbBucket2);
		expect(dbBucketConnector.findAll()).andReturn(iterableResult);
		expect(bucketMapper.mapToBucket(dbBucket1)).andReturn(bucket1);
		expect(bucketMapper.mapToBucket(dbBucket2)).andReturn(bucket2);

		this.replay();

		List<Bucket> actualBuckets = bucketRepositoryImpl.findAll();

		this.verify();

		Assert.assertEquals(2, actualBuckets.size());
		assertThat(actualBuckets, Matchers.contains(bucket1, bucket2));
	}

	@Test
	public void testFindAllWithNoBuckets() {

		Iterable<DbBucket> iterableResult = IterableHelper.convertToIterable();
		expect(dbBucketConnector.findAll()).andReturn(iterableResult);

		this.replay();

		List<Bucket> actualBuckets = bucketRepositoryImpl.findAll();

		this.verify();

		Assert.assertEquals(0, actualBuckets.size());
	}

	@Test
	public void testSave() {
		Bucket bucket = bucketMother.generate(BUCKET_NAME.GERMANY);
		DbBucket dbBucket = dbBucketMother.generate(DB_BUCKET_NAME.GERMANY);

		expect(bucketMapper.mapToDB_Bucket(bucket)).andReturn(dbBucket);
		expect(dbBucketConnector.save(dbBucket)).andReturn(dbBucket);
		expect(bucketMapper.mapToBucket(dbBucket)).andReturn(bucket);

		this.replay();

		Bucket savedBucket = this.bucketRepositoryImpl.save(bucket);

		this.verify();

		assertSame(bucket, savedBucket);

	}

}
