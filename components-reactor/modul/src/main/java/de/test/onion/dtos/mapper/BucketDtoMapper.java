package de.test.onion.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import de.test.onion.domain.Bucket;
import de.test.onion.domain.Item;
import de.test.onion.domain.common.Mapper;
import de.test.onion.dtos.BucketDto;
import de.test.onion.dtos.CreateBucketDto;
import de.test.onion.dtos.ItemDto;
import lombok.RequiredArgsConstructor;

@Mapper
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BucketDtoMapper {

	private final ItemDtoMapper itemDtoMapper;

	public Bucket mapToBucket(BucketDto bucketDto) {
		// TODO the list of the dto could be null
		List<Item> items = bucketDto.getItems().stream().map(itemDtoMapper::mapToItem).collect(Collectors.toList());

		return new Bucket(bucketDto.getId(), bucketDto.getName(), items);
	}

	public BucketDto mapToBucketDto(Bucket bucket) {

		List<ItemDto> itemDtos = bucket.getItems().stream().map(itemDtoMapper::mapToItemDto)
				.collect(Collectors.toList());

		return new BucketDto(bucket.getId(), bucket.getName(), itemDtos);
	}

	public Bucket mapToBucket(CreateBucketDto bucketDto) {

		return new Bucket(null, bucketDto.getName(), null);
	}

}
