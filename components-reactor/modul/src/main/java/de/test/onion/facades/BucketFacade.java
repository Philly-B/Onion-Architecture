package de.test.onion.facades;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import de.test.onion.domain.Bucket;
import de.test.onion.domain.Item;
import de.test.onion.dtos.BucketDto;
import de.test.onion.dtos.CreateBucketDto;
import de.test.onion.dtos.CreateItemDto;
import de.test.onion.dtos.ItemDto;
import de.test.onion.dtos.mapper.BucketDtoMapper;
import de.test.onion.dtos.mapper.ItemDtoMapper;
import de.test.onion.exceptions.IllegalIdException;
import de.test.onion.services.BucketService;
import lombok.RequiredArgsConstructor;

@Facade
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BucketFacade {

	private final BucketService bucketService;
	private final BucketDtoMapper bucketDtoMapper;
	private final ItemDtoMapper itemDtoMapper;


	@Transactional(readOnly = true)
	public List<BucketDto> getAll() {

		return this.bucketService.getAll().stream().map(this.bucketDtoMapper::mapToBucketDto).collect(Collectors.toList());
	}


	@Transactional
	public BucketDto update(String id, BucketDto bucketDto) {

		this.assertSameId(id, bucketDto);
		Bucket bucket = this.bucketDtoMapper.mapToBucket(bucketDto);
		return this.saveBucket(bucket);
	}


	private void assertSameId(String id, BucketDto bucketDto) {

		if (StringUtils.isEmpty(id) || !id.equals(bucketDto.getId())) {
			throw new IllegalIdException();
		}
	}


	private void assertSameId(String id, ItemDto itemDto) {

		if (StringUtils.isEmpty(id) || !id.equals(itemDto.getId())) {
			throw new IllegalIdException();
		}
	}


	@Transactional
	public BucketDto createBucket(CreateBucketDto bucketDto) {

		Bucket bucket = this.bucketDtoMapper.mapToBucket(bucketDto);
		return this.saveBucket(bucket);
	}


	private BucketDto saveBucket(Bucket bucket) {

		Bucket savedBucket = this.bucketService.saveBucket(bucket);
		return this.bucketDtoMapper.mapToBucketDto(savedBucket);
	}


	@Transactional
	public void delete(String bucketId) {

		this.bucketService.delete(bucketId);
	}


	@Transactional
	public ItemDto createItem(String bucketId, CreateItemDto itemDto) {

		Item item = this.itemDtoMapper.mapToItem(itemDto);
		Item savedItem = this.bucketService.saveItem(bucketId, item);
		return this.itemDtoMapper.mapToItemDto(savedItem);
	}


	@Transactional
	public ItemDto updateItem(String bucketId, String itemId, ItemDto itemDto) {

		this.assertSameId(itemId, itemDto);
		Item item = this.itemDtoMapper.mapToItem(itemDto);
		Item savedItem = this.bucketService.saveItem(bucketId, item);
		return this.itemDtoMapper.mapToItemDto(savedItem);
	}


	@Transactional
	public void deleteItem(String bucketId, String itemId) {

		this.bucketService.deleteItem(bucketId, itemId);
	}

}
