package ets.secure_webapp.entities;

import java.sql.Timestamp;

public class User {

	private Integer id_user;
	private Role role;
	private String username;
	private String password;
	private String surname;
	private String name;
	private String avatar;
	private String country;
	private Timestamp date;

	public User(Integer id_user, Role role, String username, String password, String surname, String name,
			String avatar, String country, Timestamp date) {
		super();
		this.id_user = id_user;
		this.role = role;
		this.username = username;
		this.password = password;
		this.surname = surname;
		this.name = name;
		this.avatar = avatar;
		this.country = country;
		this.date = date;
	}

	// Custom methods

	public boolean isAdmin() {
		if (role.getName().equals("admin")) {
			return true;
		}
		return false;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
}