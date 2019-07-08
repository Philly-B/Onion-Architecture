package de.test.onion.repositories;

import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import de.test.onion.domain.Bucket;
import de.test.onion.domain.common.AbstractCommonTest;
import de.test.onion.domain.mothers.BucketMother;
import de.test.onion.domain.mothers.BucketMother.BUCKET_NAME;
import de.test.onion.repositories.conntectors.DbBucketConnector;
import de.test.onion.repositories.mappers.BucketMapper;
import de.test.onion.repositories.mappers.ItemMapper;
import de.test.onion.repositories.models.DbBucket;
import de.test.onion.repositories.mothers.DbBucketMother;
import de.test.onion.repositories.mothers.DbBucketMother.DB_BUCKET_NAME;

public class BucketRepositoryImplTest extends AbstractCommonTest {

	private BucketRepositoryImpl bucketRepositoryImpl;

	private final DbBucketConnector dbBucketConnector = this.createMock(DbBucketConnector.class);
	private final BucketMapper bucketMapper = this.createMock(BucketMapper.class);
	private final ItemMapper itemMapper = this.createMock(ItemMapper.class);

	private final DbBucketMother dbBucketMother = this.createMother(DbBucketMother.class);
	private final BucketMother bucketMother = this.createMother(BucketMother.class);


	@Override
	public void initialize() {

		this.bucketRepositoryImpl = new BucketRepositoryImpl(this.dbBucketConnector, this.bucketMapper, this.itemMapper);

	}


	@Test
	public void testFindAll() {

		DbBucket dbBucket1 = this.dbBucketMother.generate(DB_BUCKET_NAME.GERMANY);
		Bucket bucket1 = this.bucketMother.generate(BUCKET_NAME.GERMANY);
		DbBucket dbBucket2 = this.dbBucketMother.generate(DB_BUCKET_NAME.USA);
		Bucket bucket2 = this.bucketMother.generate(BUCKET_NAME.USA);
		EasyMock.expect(this.dbBucketConnector.findAll()).andReturn(Arrays.asList(dbBucket1, dbBucket2));
		EasyMock.expect(this.bucketMapper.mapToBucket(dbBucket1)).andReturn(bucket1);
		EasyMock.expect(this.bucketMapper.mapToBucket(dbBucket2)).andReturn(bucket2);

		this.replay();

		List<Bucket> actualBuckets = this.bucketRepositoryImpl.findAll();

		this.verify();

		Assert.assertEquals(2, actualBuckets.size());
		Assert.assertThat(actualBuckets, Matchers.contains(bucket1, bucket2));
	}


	@Test
	public void testFindAllWithNoBuckets() {

		EasyMock.expect(this.dbBucketConnector.findAll()).andReturn(Lists.newArrayList());

		this.replay();

		List<Bucket> actualBuckets = this.bucketRepositoryImpl.findAll();

		this.verify();

		Assert.assertEquals(0, actualBuckets.size());
	}


	@Test
	public void testSave() {

		Bucket bucket = this.bucketMother.generate(BUCKET_NAME.GERMANY);
		DbBucket dbBucket = this.dbBucketMother.generate(DB_BUCKET_NAME.GERMANY);

		EasyMock.expect(this.bucketMapper.mapToDB_Bucket(bucket)).andReturn(dbBucket);
		EasyMock.expect(this.dbBucketConnector.save(dbBucket)).andReturn(dbBucket);
		EasyMock.expect(this.bucketMapper.mapToBucket(dbBucket)).andReturn(bucket);

		this.replay();

		Bucket savedBucket = this.bucketRepositoryImpl.save(bucket);

		this.verify();

		Assert.assertSame(bucket, savedBucket);

	}

}
