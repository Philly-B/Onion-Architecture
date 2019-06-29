package de.test.onion.repositories.mothers;

import com.google.common.collect.Lists;

import de.test.onion.domain.common.AbstractTestMother;
import de.test.onion.domain.common.TestMotherName;
import de.test.onion.repositories.models.DbBucket;
import de.test.onion.repositories.models.DbItem;
import de.test.onion.repositories.mothers.DbBucketMother.DB_BUCKET_NAME;
import de.test.onion.repositories.mothers.DbItemMother.DB_ITEM_NAME;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DbBucketMother extends AbstractTestMother<DB_BUCKET_NAME, DbBucket> {

	public enum DB_BUCKET_NAME implements TestMotherName {
		GERMANY, USA
	};

	private final DbItemMother dbItemsMother = new DbItemMother();

	@Override
	protected DbBucket generateTheObject(DB_BUCKET_NAME enumOfMother) {
		switch (enumOfMother) {
			case GERMANY :
				return generateDbBucket(enumOfMother, generateDb_Item(DB_ITEM_NAME.BERLIN),
						generateDb_Item(DB_ITEM_NAME.HAMBURG));
			case USA :
				return null;
			default :
				throw new NotImplementedException();
		}
	}

	private DbBucket generateDbBucket(DB_BUCKET_NAME enumOfMother, DbItem... db_Items) {

		return new DbBucket(this.getNextId(), enumOfMother.toString().toLowerCase(), Lists.newArrayList(db_Items));
	}

	private DbItem generateDb_Item(DB_ITEM_NAME itemName) {
		return dbItemsMother.generate(itemName);
	}

}
