package pojoClases;

import java.util.List;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CreateCompany{
	private String company_type;
	private String company_name;
	private String email_owner;
	private List<String> company_users;
}