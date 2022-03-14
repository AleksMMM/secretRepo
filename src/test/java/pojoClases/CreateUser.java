package pojoClases;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUser{
	private String birthday;
	private String fathername1;
	private String gender;
	private String hamster;
	private String inn;
	private String cavy;
	private List<Integer> companies;
	private String surname1;
	private String squirrel;
	private String dateStart;
	private String phone;
	private String cat;
	private String name;
	private String adres;
	private String name1;
	private String dog;
	private String parrot;
	private String email;
	private List<Integer> tasks;
	private String hobby;
}