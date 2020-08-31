package online.renting.entity;

public class Customer {
	private Integer cust_id;
	private String cust_name;
	private String cust_email;
	private String cust_pw;
	private String cust_phone;
	private String cust_country;
	
	public Customer() {
		
	}
	
	public Customer(Integer cust_id, String cust_name, String cust_email, String cust_pw, String cust_phone,
			String cust_country) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_email = cust_email;
		this.cust_pw = cust_pw;
		this.cust_phone = cust_phone;
		this.cust_country = cust_country;
	}

	public Integer getCust_id() {
		return cust_id;
	}
	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_email() {
		return cust_email;
	}
	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	public String getCust_pw() {
		return cust_pw;
	}
	public void setCust_pw(String cust_pw) {
		this.cust_pw = cust_pw;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_country() {
		return cust_country;
	}
	public void setCust_country(String cust_country) {
		this.cust_country = cust_country;
	}

	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_email=" + cust_email + ", cust_pw="
				+ cust_pw + ", cust_phone=" + cust_phone + ", cust_country=" + cust_country + "]";
	}
	
}
