package de.test.onion.repositories.models;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DB_Bucket {

	@Id
	private Long id;
	private String name;
	private List<DB_Item> items;

}
