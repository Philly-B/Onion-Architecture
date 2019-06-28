package de.test.onion.repositories.models;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DB_Item {

	@Id
	private Long id;
	private String name;
	private double value;

}
