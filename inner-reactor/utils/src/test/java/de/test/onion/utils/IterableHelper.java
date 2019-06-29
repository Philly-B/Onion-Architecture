package de.test.onion.utils;

import java.util.Arrays;
import java.util.Iterator;

import com.google.common.collect.FluentIterable;

public class IterableHelper {

	@SafeVarargs
	public static <T> FluentIterable<T> convertToIterable(T... objects) {
		return new FluentIterable<T>() {

			@Override
			public Iterator<T> iterator() {

				return Arrays.asList(objects).iterator();
			}
		};
	}

}
