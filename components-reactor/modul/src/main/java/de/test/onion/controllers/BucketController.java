package de.test.onion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import de.test.onion.controllers.constants.Urls;
import de.test.onion.dtos.BucketDto;
import de.test.onion.dtos.CreateBucketDto;
import de.test.onion.dtos.ErrorResponseDto;
import de.test.onion.exceptions.IllegalIdException;
import de.test.onion.facades.BucketFacade;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BucketController {

	private final BucketFacade bucketFacade;

	@GetMapping(path = Urls.BUCKET_ENDPOINT)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public List<BucketDto> getAllBuckets() {

		return bucketFacade.getAll();
	}

	@PutMapping(path = Urls.BUCKET_ENDPOINT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public BucketDto createBucket(@RequestBody CreateBucketDto bucketDto) {

		return bucketFacade.createBucket(bucketDto);
	}

	@PostMapping(path = Urls.BUCKET_ENDPOINT_SINGLE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public BucketDto updateBucket(@PathVariable(Urls.BUCKET_ID_URL_PARAMETER) String bucketId,
			@RequestBody BucketDto bucketDto) {

		return bucketFacade.update(bucketId, bucketDto);
	}

	@DeleteMapping(path = Urls.BUCKET_ENDPOINT_SINGLE)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public void updateBucket(@PathVariable(Urls.BUCKET_ID_URL_PARAMETER) String bucketId) {

		bucketFacade.delete(bucketId);
	}

	@ExceptionHandler(value = IllegalIdException.class)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponseDto handleIllegalIdException(IllegalIdException e) {

		ErrorResponseDto errorResponse = new ErrorResponseDto("Invalid ID",
				"The ids of the url and the dto did not match up!");
		return errorResponse;
	}

}
