package utilities;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.time.Month;

@Entity
@Table(name="DateAndTime")
public class DateAndTime{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	private LocalDateTime dateObj;
	private String formattedDate;
	@Column(name="year")
	int year;
	@Column(name="month")
	int month;
	@Column(name="day")
	int day;
	@Column(name="hour")
	int hour;
	@Column(name="minute")
	int minute; 
	@Column(name="seconds")
	int seconds;
	public DateAndTime(int year, int month, int day, int hour, int minute, int seconds) {

		this.year=year;
		this.month=month;
		this.day=day;
		this.hour=hour;
		this.minute=minute;
		this.seconds=seconds;
		Month m1 = Month.of(month);
		dateObj = LocalDateTime.of(year,m1, day, hour,minute, seconds);
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    formattedDate = dateObj.format(myFormatObj);
	  
	}
	public String getDateAndTime() {
		return formattedDate;
	}
	public String toString() {
		String returnVal = String.format("%d %d %d %d %d %d", year,month, day, hour,minute, seconds);
		return returnVal;
	}
	public void setDateAndTime(int year, int month, int day, int hour, int minute, int seconds) {
		Month m1 = Month.of(month);
		dateObj = LocalDateTime.of(year,m1, day, hour,minute, seconds);
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    formattedDate = dateObj.format(myFormatObj);
	}
}