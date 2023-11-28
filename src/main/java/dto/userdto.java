package dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class userdto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
String name;
@Column(unique = true)
String email;
String password;
String gender;
LocalDate dob;
int age;
}
