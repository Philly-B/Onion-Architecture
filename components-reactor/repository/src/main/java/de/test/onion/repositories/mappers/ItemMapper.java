package de.test.onion.repositories.mappers;

import de.test.onion.domain.Item;
import de.test.onion.domain.common.Mapper;
import de.test.onion.repositories.models.DbItem;

@Mapper
public class ItemMapper {

	public DbItem mapToDbItem(Item item) {

		return new DbItem(item.getId(), item.getName(), item.getValue());
	}

	public Item mapToItem(DbItem db_item) {

		return new Item(db_item.getId(), db_item.getName(), db_item.getValue());
	}

}
