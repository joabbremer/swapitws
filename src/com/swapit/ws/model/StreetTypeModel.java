package com.swapit.ws.model;


public class StreetTypeModel {
	
	private String streettypeid;
	private String name;
	
	public StreetTypeModel() {
		super();
	}
	
	public StreetTypeModel(String streettypeid, String name) {
		super();
		this.streettypeid = streettypeid;
		this.name = name;
	}
	
	public String getStreettypeid() {
		return streettypeid;
	}
	
	public void setStreettypeid(String streettypeid) {
		this.streettypeid = streettypeid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "StreetTypeModel [streettypeid=" + streettypeid + ", name=" + name + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((streettypeid == null) ? 0 : streettypeid.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StreetTypeModel other = (StreetTypeModel) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (streettypeid == null) {
			if (other.streettypeid != null)
				return false;
		} else if (!streettypeid.equals(other.streettypeid))
			return false;
		return true;
	}
	
	

}
