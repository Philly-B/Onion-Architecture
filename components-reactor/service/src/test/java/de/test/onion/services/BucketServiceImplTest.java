package de.test.onion.services;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.easymock.EasyMock.*;

import de.test.onion.domain.Bucket;
import de.test.onion.domain.common.AbstractCommonTest;
import de.test.onion.domain.mothers.BucketMother;
import de.test.onion.domain.mothers.BucketMother.BUCKET_NAME;
import de.test.onion.repositories.BucketRepository;
import de.test.onion.services.exceptions.InvalidBucketNameException;
import de.test.onion.services.validators.BucketValidator;

public class BucketServiceImplTest extends AbstractCommonTest {

	private BucketServiceImpl bucketServiceImpl;

	private final BucketRepository bucketRepositoryMock = this.createMock(BucketRepository.class);
	private final BucketValidator bucketValidatorMock = this.createMock(BucketValidator.class);

	private final BucketMother bucketMother = this.createMother(BucketMother.class);

	@Override
	public void initialize() {

		bucketServiceImpl = new BucketServiceImpl(bucketRepositoryMock, bucketValidatorMock);
	}

	@Test
	public void testGetAll() {

		Bucket bucket1 = bucketMother.generate(BUCKET_NAME.GERMANY);
		Bucket bucket2 = bucketMother.generate(BUCKET_NAME.USA);

		expect(bucketRepositoryMock.findAll()).andReturn(Arrays.asList(bucket1, bucket2));

		this.replay();

		List<Bucket> actual = bucketServiceImpl.getAll();

		this.verify();

		assertThat(actual, Matchers.contains(bucket1, bucket2));
	}

	@Test
	public void testSaveHappy() {

		Bucket bucket = bucketMother.generate(BUCKET_NAME.USA);

		bucketValidatorMock.validateBucket(bucket);
		expect(bucketRepositoryMock.save(bucket)).andReturn(bucket);

		this.replay();

		Bucket actual = bucketServiceImpl.saveBucket(bucket);

		this.verify();

		assertSame(bucket, actual);

	}

	@Test
	public void testSaveInvalid() {

		Bucket bucket = bucketMother.generate(BUCKET_NAME.USA);
		InvalidBucketNameException exceptionOfValidator = new InvalidBucketNameException("test");

		bucketValidatorMock.validateBucket(bucket);
		EasyMock.expectLastCall().andThrow(exceptionOfValidator);

		this.replay();

		try {
			bucketServiceImpl.saveBucket(bucket);
			Assert.fail();
		} catch (InvalidBucketNameException e) {
			this.verify();
			assertSame(exceptionOfValidator, e);
		}
	}

}
