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
import ci.gcorp.aajesepci.dao.repository.customize._MemberRepository;

/**
 * Repository : Member.
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>, _MemberRepository {
	/**
	 * Finds Member by using id as a search criteria.
	 * 
	 * @param id
	 * @return An Object Member whose id is equals to the given id. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.id = :id")
	Member findOne(@Param("id")Integer id);

	/**
	 * Finds Member by using firstname as a search criteria.
	 * 
	 * @param firstname
	 * @return An Object Member whose firstname is equals to the given firstname. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.firstname = :firstname")
	List<Member> findByFirstname(@Param("firstname")String firstname);
	/**
	 * Finds Member by using lastname as a search criteria.
	 * 
	 * @param lastname
	 * @return An Object Member whose lastname is equals to the given lastname. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.lastname = :lastname")
	List<Member> findByLastname(@Param("lastname")String lastname);
	/**
	 * Finds Member by using bornon as a search criteria.
	 * 
	 * @param bornon
	 * @return An Object Member whose bornon is equals to the given bornon. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.bornon = :bornon")
	List<Member> findByBornon(@Param("bornon")Date bornon);
	/**
	 * Finds Member by using gender as a search criteria.
	 * 
	 * @param gender
	 * @return An Object Member whose gender is equals to the given gender. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.gender = :gender")
	List<Member> findByGender(@Param("gender")String gender);
	/**
	 * Finds Member by using job as a search criteria.
	 * 
	 * @param job
	 * @return An Object Member whose job is equals to the given job. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.job = :job")
	List<Member> findByJob(@Param("job")String job);
	/**
	 * Finds Member by using email as a search criteria.
	 * 
	 * @param email
	 * @return An Object Member whose email is equals to the given email. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.email = :email")
	Member findByEmail(@Param("email")String email);
	/**
	 * Finds Member by using promoinp as a search criteria.
	 * 
	 * @param promoinp
	 * @return An Object Member whose promoinp is equals to the given promoinp. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.promoinp = :promoinp")
	List<Member> findByPromoinp(@Param("promoinp")String promoinp);
	/**
	 * Finds Member by using studiedsectorinp as a search criteria.
	 * 
	 * @param studiedsectorinp
	 * @return An Object Member whose studiedsectorinp is equals to the given studiedsectorinp. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.studiedsectorinp = :studiedsectorinp")
	List<Member> findByStudiedsectorinp(@Param("studiedsectorinp")String studiedsectorinp);
	/**
	 * Finds Member by using maritalstatus as a search criteria.
	 * 
	 * @param maritalstatus
	 * @return An Object Member whose maritalstatus is equals to the given maritalstatus. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.maritalstatus = :maritalstatus")
	List<Member> findByMaritalstatus(@Param("maritalstatus")String maritalstatus);
	/**
	 * Finds Member by using nameofspouse as a search criteria.
	 * 
	 * @param nameofspouse
	 * @return An Object Member whose nameofspouse is equals to the given nameofspouse. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.nameofspouse = :nameofspouse")
	List<Member> findByNameofspouse(@Param("nameofspouse")String nameofspouse);
	/**
	 * Finds Member by using churchattended as a search criteria.
	 * 
	 * @param churchattended
	 * @return An Object Member whose churchattended is equals to the given churchattended. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.churchattended = :churchattended")
	List<Member> findByChurchattended(@Param("churchattended")String churchattended);
	/**
	 * Finds Member by using placeofresidence as a search criteria.
	 * 
	 * @param placeofresidence
	 * @return An Object Member whose placeofresidence is equals to the given placeofresidence. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.placeofresidence = :placeofresidence")
	List<Member> findByPlaceofresidence(@Param("placeofresidence")String placeofresidence);
	/**
	 * Finds Member by using isepici as a search criteria.
	 * 
	 * @param isepici
	 * @return An Object Member whose isepici is equals to the given isepici. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.isepici = :isepici")
	List<Member> findByIsepici(@Param("isepici")Byte isepici);
	/**
	 * Finds Member by using district as a search criteria.
	 * 
	 * @param district
	 * @return An Object Member whose district is equals to the given district. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.district = :district")
	List<Member> findByDistrict(@Param("district")String district);
	/**
	 * Finds Member by using secteur as a search criteria.
	 * 
	 * @param secteur
	 * @return An Object Member whose secteur is equals to the given secteur. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.secteur = :secteur")
	List<Member> findBySecteur(@Param("secteur")String secteur);
	/**
	 * Finds Member by using assemblee as a search criteria.
	 * 
	 * @param assemblee
	 * @return An Object Member whose assemblee is equals to the given assemblee. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.assemblee = :assemblee")
	List<Member> findByAssemblee(@Param("assemblee")String assemblee);
	/**
	 * Finds Member by using responsabilityinchuch as a search criteria.
	 * 
	 * @param responsabilityinchuch
	 * @return An Object Member whose responsabilityinchuch is equals to the given responsabilityinchuch. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.responsabilityinchuch = :responsabilityinchuch")
	List<Member> findByResponsabilityinchuch(@Param("responsabilityinchuch")String responsabilityinchuch);
	/**
	 * Finds Member by using photo as a search criteria.
	 * 
	 * @param photo
	 * @return An Object Member whose photo is equals to the given photo. If
	 *         no Member is found, this method returns null.
	 */
	@Query("select e from Member e where e.photo = :photo")
	List<Member> findByPhoto(@Param("photo")String photo);

	/**
	 * Finds List of Member by using memberDto as a search criteria.
	 * 
	 * @param request, em
	 * @return A List of Member
	 * @throws DataAccessException,ParseException
	 */
	default List<Member> getByCriteria(Request<MemberDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
		String req = "select e from Member e where e IS NOT NULL";
		HashMap<String, java.lang.Object> param = new HashMap<String, java.lang.Object>();
		req += getWhereExpression(request, param, locale);
		req += " order by e.id desc";
		TypedQuery<Member> query = em.createQuery(req, Member.class);
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
	 * Finds count of Member by using memberDto as a search criteria.
	 * 
	 * @param request, em
	 * @return Number of Member
	 * 
	 */
	default Long count(Request<MemberDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
		String req = "select count(e.id) from Member e where e IS NOT NULL";
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
	default String getWhereExpression(Request<MemberDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
		// main query
		MemberDto dto = request.getData() != null ? request.getData() : new MemberDto();
		String mainReq = generateCriteria(dto, param, 0, locale);
		// others query
		String othersReq = "";
		if (request.getDatas() != null && !request.getDatas().isEmpty()) {
			Integer index = 1;
			for (MemberDto elt : request.getDatas()) {
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
	default String generateCriteria(MemberDto dto, HashMap<String, java.lang.Object> param, Integer index,  Locale locale) throws Exception{
		List<String> listOfQuery = new ArrayList<String>();
		if (dto != null) {
			if (dto.getId()!= null && dto.getId() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getFirstname())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("firstname", dto.getFirstname(), "e.firstname", "String", dto.getFirstnameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getLastname())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("lastname", dto.getLastname(), "e.lastname", "String", dto.getLastnameParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getBornon())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("bornon", dto.getBornon(), "e.bornon", "Date", dto.getBornonParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getGender())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("gender", dto.getGender(), "e.gender", "String", dto.getGenderParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getJob())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("job", dto.getJob(), "e.job", "String", dto.getJobParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getEmail())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("email", dto.getEmail(), "e.email", "String", dto.getEmailParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getPromoinp())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("promoinp", dto.getPromoinp(), "e.promoinp", "String", dto.getPromoinpParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getStudiedsectorinp())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("studiedsectorinp", dto.getStudiedsectorinp(), "e.studiedsectorinp", "String", dto.getStudiedsectorinpParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getMaritalstatus())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("maritalstatus", dto.getMaritalstatus(), "e.maritalstatus", "String", dto.getMaritalstatusParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getNameofspouse())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("nameofspouse", dto.getNameofspouse(), "e.nameofspouse", "String", dto.getNameofspouseParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getChurchattended())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("churchattended", dto.getChurchattended(), "e.churchattended", "String", dto.getChurchattendedParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getPlaceofresidence())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("placeofresidence", dto.getPlaceofresidence(), "e.placeofresidence", "String", dto.getPlaceofresidenceParam(), param, index, locale));
			}
			if (dto.getIsepici()!= null && dto.getIsepici() > 0) {
				listOfQuery.add(CriteriaUtils.generateCriteria("isepici", dto.getIsepici(), "e.isepici", "Byte", dto.getIsepiciParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getDistrict())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("district", dto.getDistrict(), "e.district", "String", dto.getDistrictParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getSecteur())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("secteur", dto.getSecteur(), "e.secteur", "String", dto.getSecteurParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getAssemblee())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("assemblee", dto.getAssemblee(), "e.assemblee", "String", dto.getAssembleeParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getResponsabilityinchuch())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("responsabilityinchuch", dto.getResponsabilityinchuch(), "e.responsabilityinchuch", "String", dto.getResponsabilityinchuchParam(), param, index, locale));
			}
			if (Utilities.notBlank(dto.getPhoto())) {
				listOfQuery.add(CriteriaUtils.generateCriteria("photo", dto.getPhoto(), "e.photo", "String", dto.getPhotoParam(), param, index, locale));
			}
			List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
			if (Utilities.isNotEmpty(listOfCustomQuery)) {
				listOfQuery.addAll(listOfCustomQuery);
			}
		}
		return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
	}
}
