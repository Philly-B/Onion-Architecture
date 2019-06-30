package de.test.onion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.test.onion.domain.Bucket;
import de.test.onion.repositories.BucketRepository;
import de.test.onion.services.common.Service;
import de.test.onion.services.validators.BucketValidator;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BucketServiceImpl implements BucketService {

	private final BucketRepository bucketRepository;
	private final BucketValidator bucketValidator;

	@Override
	public List<Bucket> getAll() {
		return bucketRepository.findAll();
	}

	@Override
	public Bucket saveBucket(Bucket bucket) {

		bucketValidator.validateBucket(bucket);
		return bucketRepository.save(bucket);
	}

	@Override
	public void delete(String bucketId) {
		bucketRepository.delete(bucketId);
	}

}
