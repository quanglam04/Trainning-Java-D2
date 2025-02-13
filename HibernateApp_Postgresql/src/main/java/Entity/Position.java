package Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "positions")
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long position_id;
	private String position_name;
	
	@OneToMany(mappedBy = "position")
	List<Employee> employees;
	
	public Position(long position_id, String position_name) {
		this.position_id = position_id;
		this.position_name = position_name;
	}
	
	public Position() {
		
	}

	public long getPosition_id() {
		return position_id;
	}

	public void setPosition_id(long position_id) {
		this.position_id = position_id;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	
	
	
}
