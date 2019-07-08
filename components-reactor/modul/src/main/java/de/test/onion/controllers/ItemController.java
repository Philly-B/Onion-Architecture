package de.test.onion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import de.test.onion.controllers.constants.Urls;
import de.test.onion.dtos.CreateItemDto;
import de.test.onion.dtos.ItemDto;
import de.test.onion.facades.BucketFacade;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ItemController extends AbstractController {

	private final BucketFacade bucketFacade;


	@PutMapping(path = Urls.ITEM_ENDPOINT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public ItemDto createItem(@PathVariable(Urls.BUCKET_ID_URL_PARAMETER) String bucketId,
			@RequestBody CreateItemDto itemDto) {

		return this.bucketFacade.createItem(bucketId, itemDto);
	}


	@PostMapping(path = Urls.ITEM_ENDPOINT_SINGLE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public ItemDto updateItem(@PathVariable(Urls.BUCKET_ID_URL_PARAMETER) String bucketId,
			@PathVariable(Urls.ITEM_ID_URL_PARAMETER) String itemId,
			@RequestBody ItemDto itemDto) {

		return this.bucketFacade.updateItem(bucketId, itemId, itemDto);
	}


	@DeleteMapping(path = Urls.ITEM_ENDPOINT_SINGLE)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public void updateItem(@PathVariable(Urls.BUCKET_ID_URL_PARAMETER) String bucketId,
			@PathVariable(Urls.ITEM_ID_URL_PARAMETER) String itemId) {

		this.bucketFacade.deleteItem(bucketId, itemId);
	}

}
