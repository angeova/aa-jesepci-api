

/*
 * Java controller for entity table member 
 * Created on 2019-06-17 ( Time 13:12:47 )
 * Generator tool : Telosys Tools Generator ( version 3.0.0 )
 * Copyright 2017 Savoir Faire Linux. All Rights Reserved.
 */

package ci.gcorp.aajesepci.rest.api;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ci.gcorp.aajesepci.utils.*;
import ci.gcorp.aajesepci.utils.dto.*;
import ci.gcorp.aajesepci.utils.contract.*;
import ci.gcorp.aajesepci.utils.contract.Request;
import ci.gcorp.aajesepci.utils.contract.Response;
import ci.gcorp.aajesepci.utils.enums.FunctionalityEnum;
import ci.gcorp.aajesepci.business.*;
import ci.gcorp.aajesepci.rest.fact.ControllerFactory;

/**
Controller for table "member"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/member")
public class MemberController {

	@Autowired
    private ControllerFactory<MemberDto> controllerFactory;
	@Autowired
	private MemberBusiness memberBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<MemberDto> create(@RequestBody Request<MemberDto> request) {
    	log.info("start method /member/create");
        Response<MemberDto> response = controllerFactory.create(memberBusiness, request, FunctionalityEnum.CREATE_MEMBER);
		log.info("end method /member/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<MemberDto> update(@RequestBody Request<MemberDto> request) {
    	log.info("start method /member/update");
        Response<MemberDto> response = controllerFactory.update(memberBusiness, request, FunctionalityEnum.UPDATE_MEMBER);
		log.info("end method /member/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<MemberDto> delete(@RequestBody Request<MemberDto> request) {
    	log.info("start method /member/delete");
        Response<MemberDto> response = controllerFactory.delete(memberBusiness, request, FunctionalityEnum.DELETE_MEMBER);
		log.info("end method /member/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<MemberDto> getByCriteria(@RequestBody Request<MemberDto> request) {
    	log.info("start method /member/getByCriteria");
        Response<MemberDto> response = controllerFactory.getByCriteria(memberBusiness, request, FunctionalityEnum.VIEW_MEMBER);
		log.info("end method /member/getByCriteria");
        return response;
    }
}
