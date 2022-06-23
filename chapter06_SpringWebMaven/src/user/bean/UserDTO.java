package user.bean;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class UserDTO {

	private String name;
	private String id;
	private String pwd;
	
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\n", this.name, this.id, this.pwd);
	}
}
