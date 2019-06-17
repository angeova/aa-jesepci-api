
/*
 * Java dto for entity table user 
 * Created on 2019-06-17 ( Time 13:12:47 )
 * Generator tool : Telosys Tools Generator ( version 3.0.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package ci.gcorp.aajesepci.utils.dto;

import java.util.Date;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.*;

import ci.gcorp.aajesepci.utils.contract.*;
import ci.gcorp.aajesepci.utils.dto.customize._UserDto;

/**
 * DTO for table "user"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class UserDto extends _UserDto implements Cloneable{

    private Integer    id                   ; // Primary Key

    private String     login                ;
    private String     password             ;
    private String     firstName            ;
    private String     lastName             ;
	private String     bornOn               ;
    private Boolean    locked               ;
    private Boolean    isSuperAdmin         ;
	private String     createdAt            ;
    private Boolean    isDeleted            ;
	private String     updatedAt            ;

    //----------------------------------------------------------------------
    // ENTITY LINKS FIELD ( RELATIONSHIP )
    //----------------------------------------------------------------------

	// Search param
	private SearchParam<Integer>  idParam               ;                     
	private SearchParam<String>   loginParam            ;                     
	private SearchParam<String>   passwordParam         ;                     
	private SearchParam<String>   firstNameParam        ;                     
	private SearchParam<String>   lastNameParam         ;                     
	private SearchParam<String>   bornOnParam           ;                     
	private SearchParam<Boolean>  lockedParam           ;                     
	private SearchParam<Boolean>  isSuperAdminParam     ;                     
	private SearchParam<String>   createdAtParam        ;                     
	private SearchParam<Boolean>  isDeletedParam        ;                     
	private SearchParam<String>   updatedAtParam        ;                     
    /**
     * Default constructor
     */
    public UserDto()
    {
        super();
    }
    
	//----------------------------------------------------------------------
    // clone METHOD
    //----------------------------------------------------------------------
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
