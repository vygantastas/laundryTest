package lt.bit.laundry.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients", schema = "test", catalog = "")
public class Client implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(nullable = false)
	private String name;

	@Column
	private String phone;
	
//	public Client () {
//		
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
