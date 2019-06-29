package de.test.onion.dtos.mapper;

import de.test.onion.domain.Item;
import de.test.onion.domain.common.Mapper;
import de.test.onion.dtos.ItemDto;

@Mapper
public class ItemDtoMapper {

	public ItemDto mapToItemDto(Item item) {

		return new ItemDto(item.getId(), item.getName(), item.getValue());
	}

	public Item mapToItem(ItemDto itemDto) {
		return new Item(itemDto.getId(), itemDto.getName(), itemDto.getValue());
	}
}
