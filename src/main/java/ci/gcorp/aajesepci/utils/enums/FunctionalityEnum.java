/*
 * Created on 2018-04-14 ( Time 21:52:32 )
 * Generator tool : Telosys Tools Generator ( version 3.0.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package ci.gcorp.aajesepci.utils.enums;

/**
 * 
 * @author Geo
 *
 */
 public enum FunctionalityEnum {
 	DEFAULT("DEFAULT"),

	// MEMBER
	VIEW_MEMBER("VIEW_MEMBER"),	
	CREATE_MEMBER("CREATE_MEMBER"),
	UPDATE_MEMBER("UPDATE_MEMBER"),
	DELETE_MEMBER("DELETE_MEMBER"),
	// USER
	VIEW_USER("VIEW_USER"),	
	CREATE_USER("CREATE_USER"),
	UPDATE_USER("UPDATE_USER"),
	DELETE_USER("DELETE_USER");

	private final String value;
 	public String getValue() {
 		return value;
 	}
 	private FunctionalityEnum(String value) {
 		this.value = value;
 	}
}
