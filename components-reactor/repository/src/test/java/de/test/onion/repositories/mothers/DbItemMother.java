package de.test.onion.repositories.mothers;

import java.util.concurrent.atomic.AtomicLong;

import de.test.onion.domain.common.AbstractTestMother;
import de.test.onion.domain.common.TestMotherName;
import de.test.onion.repositories.models.DbItem;
import de.test.onion.repositories.mothers.DbItemMother.DB_ITEM_NAME;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DbItemMother extends AbstractTestMother<DB_ITEM_NAME, DbItem> {

	public enum DB_ITEM_NAME implements TestMotherName {
		BERLIN, HAMBURG, NEW_YORK, LOS_ANGELES, SEATTLE
	};

	private final AtomicLong idCounter = new AtomicLong(0);

	@Override
	protected DbItem generateTheObject(DB_ITEM_NAME dbItemsName) {
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
				throw new NotImplementedException();
		}
	}

	private DbItem generateDB_Item(DB_ITEM_NAME dbItemsName, double value) {
		return new DbItem(idCounter.getAndIncrement(), dbItemsName.toString().toLowerCase(), value);
	}

}
