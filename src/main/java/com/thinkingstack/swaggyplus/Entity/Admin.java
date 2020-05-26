package com.thinkingstack.swaggyplus.Entity;
	
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	
	
	@Entity
	public class Admin {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long admin_id;
		private String name;
		private String password;
		public Admin() {
			
		}
		public Admin(Long admin_id, String name, String password) {
			super();
			this.admin_id = admin_id;
			this.name = name;
			this.password = password;
		}
		public Long getAdmin_id() {
			return admin_id;
		}
		public void setAdmin_id(Long admin_id) {
			this.admin_id = admin_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	
	
	}

