
/*
 * Created on 2019-06-17 ( Time 13:09:01 )
 * Generator tool : Telosys Tools Generator ( version 3.0.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package ci.gcorp.aajesepci.utils.contract;

import lombok.*;
import ci.gcorp.aajesepci.utils.Status;

/**
 * Response Base
 * 
 * @author Geo
 *
 */
@Data
@ToString
@NoArgsConstructor
public class ResponseBase {

	protected Status	status = new Status();
	protected boolean	hasError;
	protected String	sessionUser;
	protected Long		count;
}
