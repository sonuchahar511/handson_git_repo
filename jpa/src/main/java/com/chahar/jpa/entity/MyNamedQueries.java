package com.chahar.jpa.entity;

public enum MyNamedQueries {
	EMPLOYEE_GET_RECORDS("EMPLOYEE_GET_RECORDS"),
	EMPLOYEE_ALL_RECORDS("EMPLOYEE_ALL_RECORDS");
	
	
		 private final String code;       
	
		    private MyNamedQueries(final String code) {
		        this.code = code;
		    }
	
		    public boolean equalsName(String otherName) {
		        // (otherName == null) check is not needed because name.equals(null) returns false 
		        return code.equals(otherName);
		    }
	
		    public String toString() {
		       return this.code;
		    }
}
