package de.test.onion.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BucketDto {

	private String id;
	private String name;
	private List<ItemDto> items;

}
