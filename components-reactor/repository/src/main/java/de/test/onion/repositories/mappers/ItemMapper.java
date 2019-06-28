package de.test.onion.repositories.mappers;

import org.springframework.stereotype.Component;

import de.test.onion.domain.Item;
import de.test.onion.repositories.models.DB_Item;

@Component
public class ItemMapper {

	public DB_Item mapToDB_Item(Item item) {

		return new DB_Item(item.getId(), item.getName(), item.getValue());
	}


	public Item mapToItem(DB_Item db_item) {

		return new Item(db_item.getId(), db_item.getName(), db_item.getValue());
	}

}
