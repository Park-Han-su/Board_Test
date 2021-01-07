package rest.member.vo;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class Member {
	
	private Long id;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String password;
	private String name;
	private LocalDateTime regdate;
	
}
