package Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "permissions")
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long permission_id;
	
	private String permission_name;
	private String description;
	
	@ManyToMany(mappedBy = "permissions")
	private List<Role> roles = new ArrayList<Role>();
	public Permission(long permission_id, String permission_name, String description) {
		this.permission_id = permission_id;
		this.permission_name = permission_name;
		this.description = description;
	}
	public Permission() {
		
	}
	public long getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(long permission_id) {
		this.permission_id = permission_id;
	}
	public String getPermission_name() {
		return permission_name;
	}
	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
	
}
