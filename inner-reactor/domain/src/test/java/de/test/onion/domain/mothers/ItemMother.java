package de.test.onion.domain.mothers;

import java.util.concurrent.atomic.AtomicLong;

import de.test.onion.domain.Item;
import de.test.onion.domain.common.AbstractTestMother;
import de.test.onion.domain.common.TestMotherName;
import de.test.onion.domain.mothers.ItemMother.ITEM_NAME;

public class ItemMother extends AbstractTestMother<ITEM_NAME, Item> {

	public enum ITEM_NAME implements TestMotherName {
		BERLIN, HAMBURG, NEW_YORK, LOS_ANGELES, SEATTLE
	};

	private final AtomicLong idCounter = new AtomicLong(0);

	@Override
	protected Item generateTheObject(ITEM_NAME dbItemsName) {
		switch (dbItemsName) {
			case BERLIN :
				return generateDB_Item(dbItemsName, 12.1D);
			case NEW_YORK :
				return generateDB_Item(dbItemsName, 1.3D);
			case HAMBURG :
				return generateDB_Item(dbItemsName, 53.12D);
			case LOS_ANGELES :
				return generateDB_Item(dbItemsName, 56D);
			case SEATTLE :
				return generateDB_Item(dbItemsName, 42.2D);
			default :
				throw new IllegalArgumentException();
		}
	}

	private Item generateDB_Item(ITEM_NAME dbItemsName, double value) {
		return new Item(idCounter.getAndIncrement(), dbItemsName.toString().toLowerCase(), value);
	}

}
