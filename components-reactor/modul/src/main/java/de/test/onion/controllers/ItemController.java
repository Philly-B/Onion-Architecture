package de.test.onion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;

import de.test.onion.controllers.constants.Urls;
import de.test.onion.dtos.BucketDto;
import de.test.onion.dtos.CreateBucketDto;
import de.test.onion.facades.BucketFacade;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = Urls.ITEM_ENDPOINT)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ItemController {

	private final BucketFacade bucketFacade;

	@GetMapping
	@ResponseBody
	public List<BucketDto> getAllBuckets() {

		return Lists.newArrayList();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BucketDto getAllBuckets(@RequestBody CreateBucketDto bucketDto) {

		return null;
	}

	@PostMapping(path = Urls.ITEM_ENDPOINT_SINGLE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BucketDto updateBucket(@PathVariable(Urls.BUCKET_ID_URL_PARAMETER) String bucketId,
			@PathVariable(Urls.ITEM_ID_URL_PARAMETER) String itemId, @RequestBody BucketDto bucketDto) {

		return null;
	}

}
