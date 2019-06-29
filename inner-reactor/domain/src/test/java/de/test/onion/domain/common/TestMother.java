package de.test.onion.domain.common;

public interface TestMother<T extends TestMotherName, O> {

	void reset();

	O generate(T enumOfMother);

}
