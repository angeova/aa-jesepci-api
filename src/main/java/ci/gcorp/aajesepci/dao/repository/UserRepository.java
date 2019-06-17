package ci.gcorp.aajesepci.dao.repository;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ci.gcorp.aajesepci.utils.*;
import ci.gcorp.aajesepci.utils.dto.*;
import ci.gcorp.aajesepci.utils.contract.*;
import ci.gcorp.aajesepci.utils.contract.Request;
import ci.gcorp.aajesepci.utils.contract.Response;
import ci.gcorp.aajesepci.dao.entity.*;
import ci.gcorp.aajesepci.dao.repository.customize._UserRepository;

/**
 * Repository : User.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>, _UserRepository {
	/**
	 * Finds User by using id as a search criteria.
	 * 
	 * @param id
	 * @return An Object User whose id is equals to the given id. If
	 *         no User is found, this method returns null.
	 */
	@Query("select e from User e where e.id = :id and e.isDeleted = :isDeleted")
	User findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds User by using login as a search criteria.
	 * 
	 * @param login
	 * @return An Object User whose login is equals to the given login. If
	 *         no User is found, this method returns null.
	 */
	@Query("select e from User e where e.login = :login and e.isDeleted = :isDeleted")
	User findByLogin(@Param("login")String login, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds User by using password as a search criteria.
	 * 
	 * @param password
	 * @return An Object User whose password is equals to the given password. If
	 *         no User is found, this method returns null.
	 */
	@Query("select e from User e where e.password = :password and e.isDeleted = :isDeleted")
	List<User> findByPassword(@Param("password")String password, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds User by using firstName as a search criteria.
	 * 
	 * @param firstName
	 * @return An Object User whose firstName is equals to the given firstName. If
	 *         no User is found, this method returns null.
	 */
	@Query("select e from User e where e.firstName = :firstName and e.isDeleted = :isDeleted")
	List<User> findByFirstName(@Param("firstName")String firstName, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds User by using lastName as a search criteria.
	 * 
	 * @param lastName
	 * @return An Object User whose lastName is equals to the given lastName. If
	 *         no User is found, this method returns null.
	 */
	@Query("select e from User e where e.lastName = :lastName and e.isDeleted = :isDeleted")
	List<User> findByLastName(@Param("lastName")String lastName, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds User by using bornOn as a search criteria.
	 * 
	 * @param bornOn
	 * @return An Object User whose bornOn is equals to the given bornOn. If
	 *         no User is found, this method returns null.
	 */
	@Query("select e from User e where e.bornOn = :bornOn and e.isDeleted = :isDeleted")
	List<User> findByBornOn(@Param("bornOn")Date bornOn, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds User by using locked as a search criteria.
	 * 
	 * @param locked
	 * @return An Object User whose locked is equals to the given locked. If
	 *         no User is found, this method returns null.
	 */
	@Query("select e from User e where e.locked = :locked and e.isDeleted = :isDeleted")
	List<User> findByLocked(@Param("locked")Boolean locked, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds User by using isSuperAdmin as a search criteria.
	 * 
	 * @param isSuperAdmin
	 * @return An Object User whose isSuperAdmin is equals to the given isSuperAdmin. If
	 *         no User is found, this method returns null.
	 */
	@Query("select e from User e where e.isSuperAdmin = :isSuperAdmin and e.isDeleted = :isDeleted")
	List<User> findByIsSuperAdmin(@Param("isSuperAdmin")Boolean isSuperAdmin, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds User by using createdAt as a search criteria.
	 * 
	 * @param createdAt
	 * @return An Object User whose createdAt is equals to the given createdAt. If
	 *         no User is found, this method returns null.
	 */
	@Query("select e from User e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
	List<User> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds User by using isDeleted as a search criteria.
	 * 
	 * @param isDeleted
	 * @return An Object User whose isDeleted is equals to the given isDeleted. If
	 *         no User is found, this method returns null.
	 */
	@Query("select e from User e where e.isDeleted = :isDeleted")
	List<User> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
	/**
	 * Finds User by using updatedAt as a search criteria.
	 * 
	 * @param updatedAt
	 * @return An Object User whose updatedAt is equals to the given updatedAt. If
	 *         no User is found, this method returns null.
	 */
	@Query("select e from User e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
	List<User> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);

	/**
	 * Finds List of User by using userDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of User
	 * @throws DataAccessException,ParseException
	 */
	default List<User> getByCriteria(Request<UserDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from User e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.id desc";
		TypedQuery<User> query = em.createQuery(req, User.class);
		for (Map.Entry<String, java.lang.Object> entry : param.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		if (request.getIndex() != null && request.getSize() != null) {
			query.setFirstResult(request.getIndex() * request.getSize());
			query.setMaxResults(request.getSize());
		}
		return query.getResultList();
	}

	/**
	 * Finds count of User by using userDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of User
	 * 
	 */
	default Long count(Request<UserDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from User e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by  e.id desc";
		javax.persistence.Query query = em.createQuery(req);
		for (Map.Entry<String, java.lang.Object> entry : param.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		Long count = (Long) query.getResultList().get(0);
		return count;
	}

	/**
	 * get where expression
	 * @param request
	 * @param param
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	default String getWhereExpression(Request<UserDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		UserDto dto = request.getData() != null ? request.getData() : new UserDto();
		dto.setIsDeleted(false);
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (UserDto elt : request.getDatas()) {
				elt.setIsDeleted(false);
				String eltReq = generateCriteria(elt, param, index, locale);
				if (request.getIsAnd() != null && request.getIsAnd()) {
					othersReq += "and (" + eltReq + ") ";
				} else {
					othersReq += "or (" + eltReq + ") ";
				}
				index++;
			}
		}
		String req = "";
		if (!mainReq.isEmpty()) {
			req += " and (" + mainReq + ") ";
		}
		req += othersReq;
		return req;
	}

	/**
	 * generate sql query for dto
	 * @param dto
	 * @param param
	 * @param index
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	default String generateCriteria(UserDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getId()!= null && dto.getId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getLogin())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("login", dto.getLogin(), "e.login", "String", dto.getLoginParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getPassword())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("password", dto.getPassword(), "e.password", "String", dto.getPasswordParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getFirstName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("firstName", dto.getFirstName(), "e.firstName", "String", dto.getFirstNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getLastName())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("lastName", dto.getLastName(), "e.lastName", "String", dto.getLastNameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getBornOn())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("bornOn", dto.getBornOn(), "e.bornOn", "Date", dto.getBornOnParam(), param, index, locale));
			}
			if (dto.getLocked()!= null) {
				listOfQuery.add(CriteriaUtils.generateCriteria("locked", dto.getLocked(), "e.locked", "Boolean", dto.getLockedParam(), param, index, locale));
			}
			if (dto.getIsSuperAdmin()!= null) {
				listOfQuery.add(CriteriaUtils.generateCriteria("isSuperAdmin", dto.getIsSuperAdmin(), "e.isSuperAdmin", "Boolean", dto.getIsSuperAdminParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getCreatedAt())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("createdAt", dto.getCreatedAt(), "e.createdAt", "Date", dto.getCreatedAtParam(), param, index, locale));
			}
			if (dto.getIsDeleted()!= null) {
				listOfQuery.add(CriteriaUtils.generateCriteria("isDeleted", dto.getIsDeleted(), "e.isDeleted", "Boolean", dto.getIsDeletedParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getUpdatedAt())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("updatedAt", dto.getUpdatedAt(), "e.updatedAt", "Date", dto.getUpdatedAtParam(), param, index, locale));
			}
			List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
			if (Utilities.isNotEmpty(listOfCustomQuery)) {
				listOfQuery.addAll(listOfCustomQuery);
			}
		}
		return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
	}
}
