package de.test.onion.repositories.models;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DbItem {

	@Id
	private String id;
	private String name;
	private double value;

}
