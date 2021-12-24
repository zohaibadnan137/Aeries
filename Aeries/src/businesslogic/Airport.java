package businesslogic;
import javax.persistence.*;

@Entity
@Table(name="Airport")
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name="name")
	private String name;
	@Column(name="code")
	private String code;
	@Column(name="country")
	private String country;
	@Column(name="city")
	private String city;
	
	public Airport(String name, String code, String country, String city)
	{
		this.name = name; 
		this.code = code; 
		this.country = country;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
