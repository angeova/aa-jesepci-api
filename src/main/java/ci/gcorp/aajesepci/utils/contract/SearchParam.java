
/*
 * Created on 2019-06-17 ( Time 13:09:01 )
 * Generator tool : Telosys Tools Generator ( version 3.0.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package ci.gcorp.aajesepci.utils.contract;

import lombok.*;

/**
 * Search Param
 * 
 * @author Geo
 *
 */
@Data
@ToString
@NoArgsConstructor
public class SearchParam<T> {

	String	operator;
	T		start;
	T		end;
}
