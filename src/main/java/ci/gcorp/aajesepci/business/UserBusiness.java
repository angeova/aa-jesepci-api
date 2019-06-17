                                            												
/*
 * Java business for entity table user 
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
import ci.gcorp.aajesepci.dao.entity.User;
import ci.gcorp.aajesepci.dao.entity.*;
import ci.gcorp.aajesepci.dao.repository.*;

/**
BUSINESS for table "user"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class UserBusiness implements IBasicBusiness<Request<UserDto>, Response<UserDto>> {

	private Response<UserDto> response;
	@Autowired
	private UserRepository userRepository;
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

	public UserBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create User by using UserDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserDto> create(Request<UserDto> request, Locale locale)  throws ParseException {
		log.info("----begin create User-----");

		Response<UserDto> response = new Response<UserDto>();
		List<User>        items    = new ArrayList<User>();
			
		for (UserDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("login", dto.getLogin());
			fieldsToVerify.put("password", dto.getPassword());
			fieldsToVerify.put("firstName", dto.getFirstName());
			fieldsToVerify.put("lastName", dto.getLastName());
			fieldsToVerify.put("bornOn", dto.getBornOn());
			fieldsToVerify.put("locked", dto.getLocked());
			fieldsToVerify.put("isSuperAdmin", dto.getIsSuperAdmin());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if user to insert do not exist
			User existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("user id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// verif unique login in db
			existingEntity = userRepository.findByLogin(dto.getLogin(), false);
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("user login -> " + dto.getLogin(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique login in items to save
			if (items.stream().anyMatch(a -> a.getLogin().equalsIgnoreCase(dto.getLogin()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" login ", locale));
				response.setHasError(true);
				return response;
			}

				User entityToSave = null;
			entityToSave = UserTransformer.INSTANCE.toEntity(dto);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<User> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = userRepository.saveAll((Iterable<User>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("user", locale));
				response.setHasError(true);
				return response;
			}
			List<UserDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UserTransformer.INSTANCE.toLiteDtos(itemsSaved) : UserTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create User-----");
		return response;
	}

	/**
	 * update User by using UserDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserDto> update(Request<UserDto> request, Locale locale)  throws ParseException {
		log.info("----begin update User-----");

		Response<UserDto> response = new Response<UserDto>();
		List<User>        items    = new ArrayList<User>();
			
		for (UserDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la user existe
			User entityToSave = null;
			entityToSave = userRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("user id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			if (Utilities.notBlank(dto.getLogin())) {
				entityToSave.setLogin(dto.getLogin());
			}
			if (Utilities.notBlank(dto.getPassword())) {
				entityToSave.setPassword(dto.getPassword());
			}
			if (Utilities.notBlank(dto.getFirstName())) {
				entityToSave.setFirstName(dto.getFirstName());
			}
			if (Utilities.notBlank(dto.getLastName())) {
				entityToSave.setLastName(dto.getLastName());
			}
			if (Utilities.notBlank(dto.getBornOn())) {
				entityToSave.setBornOn(dateFormat.parse(dto.getBornOn()));
			}
			if (dto.getLocked() != null) {
				entityToSave.setLocked(dto.getLocked());
			}
			if (dto.getIsSuperAdmin() != null) {
				entityToSave.setIsSuperAdmin(dto.getIsSuperAdmin());
			}
			entityToSave.setUpdatedAt(Utilities.getCurrentDate());
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<User> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = userRepository.saveAll((Iterable<User>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("user", locale));
				response.setHasError(true);
				return response;
			}
			List<UserDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UserTransformer.INSTANCE.toLiteDtos(itemsSaved) : UserTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update User-----");
		return response;
	}

	/**
	 * delete User by using UserDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserDto> delete(Request<UserDto> request, Locale locale)  {
		log.info("----begin delete User-----");

		Response<UserDto> response = new Response<UserDto>();
		List<User>        items    = new ArrayList<User>();
			
		for (UserDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la user existe
			User existingEntity = null;
			existingEntity = userRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("user -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------



			existingEntity.setIsDeleted(true);
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			userRepository.saveAll((Iterable<User>) items);

			response.setHasError(false);
		}

		log.info("----end delete User-----");
		return response;
	}

	/**
	 * get User by using UserDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserDto> getByCriteria(Request<UserDto> request, Locale locale)  throws Exception {
		log.info("----begin get User-----");

		Response<UserDto> response = new Response<UserDto>();
		List<User> items 			 = userRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<UserDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UserTransformer.INSTANCE.toLiteDtos(items) : UserTransformer.INSTANCE.toDtos(items);

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
			response.setCount(userRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("user", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get User-----");
		return response;
	}

	/**
	 * get full UserDto by using User as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private UserDto getFullInfos(UserDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
