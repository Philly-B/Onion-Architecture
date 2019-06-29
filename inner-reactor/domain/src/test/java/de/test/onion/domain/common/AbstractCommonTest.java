package de.test.onion.domain.common;

import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;

import com.google.common.collect.Lists;

public abstract class AbstractCommonTest {

	public abstract void initialize();

	private final List<Object> mocks = Lists.newArrayList();
	private final List<TestMother<?, ?>> mothers = Lists.newArrayList();

	@Before
	public void init() {

		EasyMock.reset(mocks.toArray());
		mothers.forEach(TestMother::reset);
		initialize();
	}

	public <T> T createMock(Class<T> classToMock) {

		T classMock = EasyMock.createMock(classToMock);
		mocks.add(classMock);
		return classMock;
	}

	protected <T extends TestMother<?, ?>> T createMother(Class<T> motherImplClass) {
		T mother = createInstanceSafe(motherImplClass);
		mothers.add(mother);
		return mother;
	}

	private <T extends TestMother<?, ?>> T createInstanceSafe(Class<T> motherImplClass) {
		try {
			return motherImplClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new IllegalArgumentException();
		}
	}

	public void replay(Object... additionalMocks) {
		EasyMock.replay(mocks.toArray());
		EasyMock.replay(additionalMocks);
	}

	public void verify(Object... additionalMocks) {
		EasyMock.verify(mocks.toArray());
		EasyMock.verify(additionalMocks);
	}

}
