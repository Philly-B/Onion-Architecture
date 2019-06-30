package de.test.onion.controllers.constants;

public class Urls {

	public static final String REST_API = "/rest/api";

	public static final String BUCKET_ENDPOINT = REST_API + "/buckets";
	public static final String BUCKET_ID_URL_PARAMETER = "bucketId";
	public static final String BUCKET_ENDPOINT_SINGLE = BUCKET_ENDPOINT + "/{" + BUCKET_ID_URL_PARAMETER + "}";

	public static final String ITEM_ENDPOINT = BUCKET_ENDPOINT_SINGLE + "/items";
	public static final String ITEM_ID_URL_PARAMETER = "itemId";
	public static final String ITEM_ENDPOINT_SINGLE = ITEM_ENDPOINT + "/{" + ITEM_ID_URL_PARAMETER + "}";

}
