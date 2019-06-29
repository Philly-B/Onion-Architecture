package de.test.onion.domain.mothers;

import com.google.common.collect.Lists;

import de.test.onion.domain.Bucket;
import de.test.onion.domain.Item;
import de.test.onion.domain.common.AbstractTestMother;
import de.test.onion.domain.common.TestMotherName;
import de.test.onion.domain.mothers.BucketMother.BUCKET_NAME;
import de.test.onion.domain.mothers.ItemMother.ITEM_NAME;

public class BucketMother extends AbstractTestMother<BUCKET_NAME, Bucket> {

	public enum BUCKET_NAME implements TestMotherName {
		GERMANY, USA
	};

	private final ItemMother itemMother = new ItemMother();

	@Override
	protected Bucket generateTheObject(BUCKET_NAME enumOfMother) {
		switch (enumOfMother) {
			case GERMANY :
				return generateBucket(enumOfMother, generateItem(ITEM_NAME.BERLIN), generateItem(ITEM_NAME.HAMBURG));
			case USA :
				return null;
			default :
				throw new IllegalArgumentException();
		}
	}

	private Bucket generateBucket(BUCKET_NAME enumOfMother, Item... db_Items) {

		return new Bucket(this.getNextId(), enumOfMother.toString().toLowerCase(), Lists.newArrayList(db_Items));
	}

	private Item generateItem(ITEM_NAME itemName) {
		return itemMother.generate(itemName);
	}

}
