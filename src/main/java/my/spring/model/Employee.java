package my.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// If name is same than no need to put
@Entity
@Table(name="Employee")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String FName;
	private String MName;
	private String LName;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date Date;
	private boolean Type;
	
	public Employee(){}
	
	public Employee(String fName, String mName, String lName, Date date, boolean type) {
		FName = fName;
		MName = mName;
		LName = lName;
		Date = date;
		this.Type = type;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getMName() {
		return MName;
	}
	public void setMName(String mName) {
		MName = mName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public boolean isType() {
		return Type;
	}
	public void setType(boolean type) {
		this.Type = type;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", FName=" + FName + ", MName=" + MName + ", LName=" + LName + ", Date=" + Date
				+ ", type=" + Type + "]";
	}
}
