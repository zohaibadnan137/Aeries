package businesslogic;
import javax.persistence.*;
@Entity
@Table(name="Complaint")
public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name="complaintID")
	private int complaintID;
	@Column(name="Description")
	private String description;
	@OneToOne(cascade = CascadeType.ALL)
	public BoardingPass boardingPass;
	public Complaint(int complaintID, String description,BoardingPass boardingPass)
	{
		this.complaintID = complaintID;
		this.description = description;
		this.boardingPass = boardingPass;
		PersistenceFactory.getHandler().save(this);
	}
	public int getComplaintID()
	{
		return this.complaintID;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getDescription()
	{
		return this.description;
	}
	public BoardingPass getBoardingPass()
	{
		return this.boardingPass;
	}
}
