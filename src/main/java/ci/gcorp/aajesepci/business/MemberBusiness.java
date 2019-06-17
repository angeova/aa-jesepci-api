                                                                            																			
/*
 * Java business for entity table member 
 * Created on 2019-06-17 ( Time 13:12:47 )
 * Generator tool : Telosys Tools Generator ( version 3.0.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package ci.gcorp.aajesepci.business;

import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import ci.gcorp.aajesepci.utils.*;
import ci.gcorp.aajesepci.utils.dto.*;
import ci.gcorp.aajesepci.utils.enums.*;
import ci.gcorp.aajesepci.utils.contract.*;
import ci.gcorp.aajesepci.utils.contract.IBasicBusiness;
import ci.gcorp.aajesepci.utils.contract.Request;
import ci.gcorp.aajesepci.utils.contract.Response;
import ci.gcorp.aajesepci.utils.dto.transformer.*;
import ci.gcorp.aajesepci.dao.entity.Member;
import ci.gcorp.aajesepci.dao.entity.*;
import ci.gcorp.aajesepci.dao.repository.*;

/**
BUSINESS for table "member"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class MemberBusiness implements IBasicBusiness<Request<MemberDto>, Response<MemberDto>> {

	private Response<MemberDto> response;
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private FunctionalError functionalError;
	@Autowired
	private TechnicalError technicalError;
	@Autowired
	private ExceptionUtils exceptionUtils;
	@PersistenceContext
	private EntityManager em;

	private SimpleDateFormat dateFormat;
	private SimpleDateFormat dateTimeFormat;

	public MemberBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Member by using MemberDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<MemberDto> create(Request<MemberDto> request, Locale locale)  throws ParseException {
		log.info("----begin create Member-----");

		Response<MemberDto> response = new Response<MemberDto>();
		List<Member>        items    = new ArrayList<Member>();
			
		for (MemberDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("firstname", dto.getFirstname());
			fieldsToVerify.put("lastname", dto.getLastname());
			fieldsToVerify.put("bornon", dto.getBornon());
			fieldsToVerify.put("gender", dto.getGender());
			fieldsToVerify.put("job", dto.getJob());
			fieldsToVerify.put("email", dto.getEmail());
			fieldsToVerify.put("promoinp", dto.getPromoinp());
			fieldsToVerify.put("studiedsectorinp", dto.getStudiedsectorinp());
			fieldsToVerify.put("maritalstatus", dto.getMaritalstatus());
			fieldsToVerify.put("nameofspouse", dto.getNameofspouse());
			fieldsToVerify.put("churchattended", dto.getChurchattended());
			fieldsToVerify.put("placeofresidence", dto.getPlaceofresidence());
			fieldsToVerify.put("isepici", dto.getIsepici());
			fieldsToVerify.put("district", dto.getDistrict());
			fieldsToVerify.put("secteur", dto.getSecteur());
			fieldsToVerify.put("assemblee", dto.getAssemblee());
			fieldsToVerify.put("responsabilityinchuch", dto.getResponsabilityinchuch());
			fieldsToVerify.put("photo", dto.getPhoto());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if member to insert do not exist
			Member existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("member id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// verif unique email in db
			existingEntity = memberRepository.findByEmail(dto.getEmail());
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("member email -> " + dto.getEmail(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique email in items to save
			if (items.stream().anyMatch(a -> a.getEmail().equalsIgnoreCase(dto.getEmail()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" email ", locale));
				response.setHasError(true);
				return response;
			}

				Member entityToSave = null;
			entityToSave = MemberTransformer.INSTANCE.toEntity(dto);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Member> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = memberRepository.saveAll((Iterable<Member>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("member", locale));
				response.setHasError(true);
				return response;
			}
			List<MemberDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? MemberTransformer.INSTANCE.toLiteDtos(itemsSaved) : MemberTransformer.INSTANCE.toDtos(itemsSaved);

			final int size = itemsSaved.size();
			List<String>  listOfError      = Collections.synchronizedList(new ArrayList<String>());
			itemsDto.parallelStream().forEach(dto -> {
				try {
					dto = getFullInfos(dto, size, request.getIsSimpleLoading(), locale);
				} catch (Exception e) {
					listOfError.add(e.getMessage());
					e.printStackTrace();
				}
			});
			if (Utilities.isNotEmpty(listOfError)) {
				Object[] objArray = listOfError.stream().distinct().toArray();
				throw new RuntimeException(StringUtils.join(objArray, ", "));
			}
			response.setItems(itemsDto);
			response.setHasError(false);
		}

		log.info("----end create Member-----");
		return response;
	}

	/**
	 * update Member by using MemberDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<MemberDto> update(Request<MemberDto> request, Locale locale)  throws ParseException {
		log.info("----begin update Member-----");

		Response<MemberDto> response = new Response<MemberDto>();
		List<Member>        items    = new ArrayList<Member>();
			
		for (MemberDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la member existe
			Member entityToSave = null;
			entityToSave = memberRepository.findOne(dto.getId());
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("member id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			if (Utilities.notBlank(dto.getFirstname())) {
				entityToSave.setFirstname(dto.getFirstname());
			}
			if (Utilities.notBlank(dto.getLastname())) {
				entityToSave.setLastname(dto.getLastname());
			}
			if (Utilities.notBlank(dto.getBornon())) {
				entityToSave.setBornon(dateFormat.parse(dto.getBornon()));
			}
			if (Utilities.notBlank(dto.getGender())) {
				entityToSave.setGender(dto.getGender());
			}
			if (Utilities.notBlank(dto.getJob())) {
				entityToSave.setJob(dto.getJob());
			}
			if (Utilities.notBlank(dto.getEmail())) {
				entityToSave.setEmail(dto.getEmail());
			}
			if (Utilities.notBlank(dto.getPromoinp())) {
				entityToSave.setPromoinp(dto.getPromoinp());
			}
			if (Utilities.notBlank(dto.getStudiedsectorinp())) {
				entityToSave.setStudiedsectorinp(dto.getStudiedsectorinp());
			}
			if (Utilities.notBlank(dto.getMaritalstatus())) {
				entityToSave.setMaritalstatus(dto.getMaritalstatus());
			}
			if (Utilities.notBlank(dto.getNameofspouse())) {
				entityToSave.setNameofspouse(dto.getNameofspouse());
			}
			if (Utilities.notBlank(dto.getChurchattended())) {
				entityToSave.setChurchattended(dto.getChurchattended());
			}
			if (Utilities.notBlank(dto.getPlaceofresidence())) {
				entityToSave.setPlaceofresidence(dto.getPlaceofresidence());
			}
			if (dto.getIsepici() != null && dto.getIsepici() > 0) {
				entityToSave.setIsepici(dto.getIsepici());
			}
			if (Utilities.notBlank(dto.getDistrict())) {
				entityToSave.setDistrict(dto.getDistrict());
			}
			if (Utilities.notBlank(dto.getSecteur())) {
				entityToSave.setSecteur(dto.getSecteur());
			}
			if (Utilities.notBlank(dto.getAssemblee())) {
				entityToSave.setAssemblee(dto.getAssemblee());
			}
			if (Utilities.notBlank(dto.getResponsabilityinchuch())) {
				entityToSave.setResponsabilityinchuch(dto.getResponsabilityinchuch());
			}
			if (Utilities.notBlank(dto.getPhoto())) {
				entityToSave.setPhoto(dto.getPhoto());
			}
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Member> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = memberRepository.saveAll((Iterable<Member>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("member", locale));
				response.setHasError(true);
				return response;
			}
			List<MemberDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? MemberTransformer.INSTANCE.toLiteDtos(itemsSaved) : MemberTransformer.INSTANCE.toDtos(itemsSaved);

			final int size = itemsSaved.size();
			List<String>  listOfError      = Collections.synchronizedList(new ArrayList<String>());
			itemsDto.parallelStream().forEach(dto -> {
				try {
					dto = getFullInfos(dto, size, request.getIsSimpleLoading(), locale);
				} catch (Exception e) {
					listOfError.add(e.getMessage());
					e.printStackTrace();
				}
			});
			if (Utilities.isNotEmpty(listOfError)) {
				Object[] objArray = listOfError.stream().distinct().toArray();
				throw new RuntimeException(StringUtils.join(objArray, ", "));
			}
			response.setItems(itemsDto);
			response.setHasError(false);
		}

		log.info("----end update Member-----");
		return response;
	}

	/**
	 * delete Member by using MemberDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<MemberDto> delete(Request<MemberDto> request, Locale locale)  {
		log.info("----begin delete Member-----");

		Response<MemberDto> response = new Response<MemberDto>();
		List<Member>        items    = new ArrayList<Member>();
			
		for (MemberDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la member existe
			Member existingEntity = null;
			existingEntity = memberRepository.findOne(dto.getId());
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("member -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------



			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			memberRepository.deleteAll((Iterable<Member>) items);

			response.setHasError(false);
		}

		log.info("----end delete Member-----");
		return response;
	}

	/**
	 * get Member by using MemberDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<MemberDto> getByCriteria(Request<MemberDto> request, Locale locale)  throws Exception {
		log.info("----begin get Member-----");

		Response<MemberDto> response = new Response<MemberDto>();
		List<Member> items 			 = memberRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<MemberDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? MemberTransformer.INSTANCE.toLiteDtos(items) : MemberTransformer.INSTANCE.toDtos(items);

			final int size = items.size();
			List<String>  listOfError      = Collections.synchronizedList(new ArrayList<String>());
			itemsDto.parallelStream().forEach(dto -> {
				try {
					dto = getFullInfos(dto, size, request.getIsSimpleLoading(), locale);
				} catch (Exception e) {
					listOfError.add(e.getMessage());
					e.printStackTrace();
				}
			});
			if (Utilities.isNotEmpty(listOfError)) {
				Object[] objArray = listOfError.stream().distinct().toArray();
				throw new RuntimeException(StringUtils.join(objArray, ", "));
			}
			response.setItems(itemsDto);
			response.setCount(memberRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("member", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get Member-----");
		return response;
	}

	/**
	 * get full MemberDto by using Member as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private MemberDto getFullInfos(MemberDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
		// put code here

		if (Utilities.isTrue(isSimpleLoading)) {
			return dto;
		}
		if (size > 1) {
			return dto;
		}

		return dto;
	}
}
