package com.DTO;

public class Employee {
		private int eid;
		private String ename;
		private int eph;
		
		
		public Employee(int eid,String ename, int eph){
			this.eid = eid;
			this.ename = ename;
			this.eph = eph;
		}
		
		@Override
		public String toString() {
			return eid +" "+ ename +" "+ eph;
		}
		public int geteid() {
			return eid;
		}
		public String getename() {
			return ename;
		}
		public int geteph() {
			return eph;
		}
		public void seteid(int id) {
			this.eid = id;
		}
		public void setename(String name) {
			this.ename = name;
		}
		public void seteph(int ph) {
			this.eph = ph;
		}
	
}
