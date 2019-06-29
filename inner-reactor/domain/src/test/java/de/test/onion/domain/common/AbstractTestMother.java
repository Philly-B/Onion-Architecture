package de.test.onion.domain.common;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractTestMother<T extends TestMotherName, O> implements TestMother<T, O> {

	private final AtomicLong idCounter = new AtomicLong(0);

	private final HashMap<T, O> cache = new HashMap<>();

	@Override
	public O generate(T enumOfMother) {
		O cachedObj = cache.get(enumOfMother);
		if (cachedObj == null) {
			cachedObj = generateTheObject(enumOfMother);
			cache.put(enumOfMother, cachedObj);
		}
		return cachedObj;
	}

	protected abstract O generateTheObject(T enumOfMother);

	protected String getNextId() {
		return Long.toString(idCounter.incrementAndGet());
	}

	@Override
	public void reset() {
		cache.clear();
	}

}
