package de.test.onion.domain;

import java.util.List;

import com.sun.istack.internal.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bucket {

	private String id;
	private @NotNull String name;
	private List<Item> items;

}
