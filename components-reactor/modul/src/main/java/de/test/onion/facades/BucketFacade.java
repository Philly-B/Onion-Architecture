package de.test.onion.facades;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import de.test.onion.domain.Bucket;
import de.test.onion.dtos.BucketDto;
import de.test.onion.dtos.CreateBucketDto;
import de.test.onion.dtos.mapper.BucketDtoMapper;
import de.test.onion.exceptions.IllegalIdException;
import de.test.onion.services.BucketService;
import lombok.RequiredArgsConstructor;

@Facade
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BucketFacade {

	private final BucketService bucketService;
	private final BucketDtoMapper bucketDtoMapper;

	@Transactional(readOnly = true)
	public List<BucketDto> getAll() {

		return bucketService.getAll().stream().map(bucketDtoMapper::mapToBucketDto).collect(Collectors.toList());
	}

	@Transactional
	public BucketDto update(String id, BucketDto bucketDto) {
		assertSameId(id, bucketDto);
		Bucket bucket = bucketDtoMapper.mapToBucket(bucketDto);
		return saveBucket(bucket);
	}

	private void assertSameId(String id, BucketDto bucketDto) {
		if (StringUtils.isEmpty(id) || !id.equals(bucketDto.getId())) {
			throw new IllegalIdException();
		}

	}

	@Transactional
	public BucketDto createBucket(CreateBucketDto bucketDto) {

		Bucket bucket = bucketDtoMapper.mapToBucket(bucketDto);
		return saveBucket(bucket);
	}

	private BucketDto saveBucket(Bucket bucket) {
		Bucket savedBucket = bucketService.saveBucket(bucket);
		return bucketDtoMapper.mapToBucketDto(savedBucket);
	}

	@Transactional
	public void delete(String bucketId) {
		bucketService.delete(bucketId);
	}

}
