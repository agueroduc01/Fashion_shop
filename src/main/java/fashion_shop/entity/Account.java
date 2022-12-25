package fashion_shop.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Account")
public class Account {
	@Column(name = "ID")
	private int ID;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int iD, String user_name, String password, String fullname, String email, Boolean gender,
			String image, Date birthday, String phone, String address, Role role) {
		super();
		ID = iD;
		this.user_name = user_name;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.gender = gender;
		this.image = image;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.role = role;
	}

	@Id
	@Column(name = "Username")
	private String user_name;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Fullname")
	private String fullname;
	
	@Column(name = "Email")
	private String email;

	@Column(name = "Gender")
	private Boolean gender;

	@Column(name = "Image")
	private String image;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "Birthday")
	private Date birthday;

	@Column(name = "Phone")
	private String phone;

	private String address;
	
	@ManyToOne 
	@JoinColumn(name = "Role")
	private Role role;
	
//	@OneToMany(mappedBy = "emails", fetch = FetchType.EAGER)
//	private Collection<Account> emails;
//	
//	public Collection<Account> getEmails() {
//		return emails;
//	}
//
//	public void setEmails(Collection<Account> emails) {
//		this.emails = emails;
//	}

	public Role getrole() {
		return role;
	}

	public void setrole(Role role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Account [ID=" + ID + ", user_name=" + user_name + ", password=" + password + ", fullname=" + fullname
				+ ", email=" + email + ", gender=" + gender + ", image=" + image + ", birthday=" + birthday + ", phone="
				+ phone + ", address=" + address + ", role=" + role + "]";
	}
}