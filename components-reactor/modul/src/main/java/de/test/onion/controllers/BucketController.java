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

import de.test.onion.controllers.constants.Urls;
import de.test.onion.dtos.BucketDto;
import de.test.onion.dtos.CreateBucketDto;
import de.test.onion.facades.BucketFacade;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = Urls.BUCKET_ENDPOINT)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BucketController {

	private final BucketFacade bucketFacade;

	@GetMapping
	@ResponseBody
	public List<BucketDto> getAllBuckets() {

		return bucketFacade.getAll();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BucketDto getAllBuckets(@RequestBody CreateBucketDto bucketDto) {

		return bucketFacade.createBucket(bucketDto);
	}

	@PostMapping(path = Urls.BUCKET_ENDPOINT_SINGLE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BucketDto updateBucket(@PathVariable("id") String id, @RequestBody BucketDto bucketDto) {

		return bucketFacade.update(id, bucketDto);
	}

}
