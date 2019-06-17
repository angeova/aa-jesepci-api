
/*
 * Java dto for entity table member 
 * Created on 2019-06-17 ( Time 13:12:46 )
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
import ci.gcorp.aajesepci.utils.dto.customize._MemberDto;

/**
 * DTO for table "member"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class MemberDto extends _MemberDto implements Cloneable{

    private Integer    id                   ; // Primary Key

    private String     firstname            ;
    private String     lastname             ;
	private String     bornon               ;
    private String     gender               ;
    private String     job                  ;
    private String     email                ;
    private String     promoinp             ;
    private String     studiedsectorinp     ;
    private String     maritalstatus        ;
    private String     nameofspouse         ;
    private String     churchattended       ;
    private String     placeofresidence     ;
    private Byte       isepici              ;
    private String     district             ;
    private String     secteur              ;
    private String     assemblee            ;
    private String     responsabilityinchuch ;
    private String     photo                ;

    //----------------------------------------------------------------------
    // ENTITY LINKS FIELD ( RELATIONSHIP )
    //----------------------------------------------------------------------

	// Search param
	private SearchParam<Integer>  idParam               ;                     
	private SearchParam<String>   firstnameParam        ;                     
	private SearchParam<String>   lastnameParam         ;                     
	private SearchParam<String>   bornonParam           ;                     
	private SearchParam<String>   genderParam           ;                     
	private SearchParam<String>   jobParam              ;                     
	private SearchParam<String>   emailParam            ;                     
	private SearchParam<String>   promoinpParam         ;                     
	private SearchParam<String>   studiedsectorinpParam ;                     
	private SearchParam<String>   maritalstatusParam    ;                     
	private SearchParam<String>   nameofspouseParam     ;                     
	private SearchParam<String>   churchattendedParam   ;                     
	private SearchParam<String>   placeofresidenceParam ;                     
	private SearchParam<Byte>     isepiciParam          ;                     
	private SearchParam<String>   districtParam         ;                     
	private SearchParam<String>   secteurParam          ;                     
	private SearchParam<String>   assembleeParam        ;                     
	private SearchParam<String>   responsabilityinchuchParam;                     
	private SearchParam<String>   photoParam            ;                     
    /**
     * Default constructor
     */
    public MemberDto()
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
