package de.test.onion.services.validators;

import java.util.regex.Pattern;

import com.google.common.collect.Lists;

import de.test.onion.domain.Bucket;
import de.test.onion.services.common.Validator;
import de.test.onion.services.exceptions.InvalidBucketNameException;

@Validator
public class BucketValidator {

	private static final String ALLOWED_BUCKET_NAMES_REGEX = "[a-zA-Z]+";
	private static final Pattern ALLOWED_BUCKET_NAMES_PATTERN = Pattern.compile(ALLOWED_BUCKET_NAMES_REGEX);

	public void validateBucket(Bucket bucket) {

		if (bucket.getName() == null || !ALLOWED_BUCKET_NAMES_PATTERN.matcher(bucket.getName()).matches()) {
			throw new InvalidBucketNameException("The bucket name " + bucket.getName() + " does not fit the regex "
					+ ALLOWED_BUCKET_NAMES_REGEX + "!");
		}

		if (bucket.getItems() == null) {
			bucket.setItems(Lists.newArrayList());
		}
	}

}
