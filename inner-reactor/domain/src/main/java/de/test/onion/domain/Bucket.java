package de.test.onion.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bucket {

	private Long id;
	private String name;
	private List<Item> items;

}
