

/*
 * Java transformer for entity table member 
 * Created on 2019-06-17 ( Time 13:12:47 )
 * Generator tool : Telosys Tools Generator ( version 3.0.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package ci.gcorp.aajesepci.utils.dto.transformer;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import ci.gcorp.aajesepci.utils.contract.*;
import ci.gcorp.aajesepci.utils.dto.*;
import ci.gcorp.aajesepci.dao.entity.*;


/**
 * TRANSFORMER for table "member"
 * 
 * @author Geo
 *
 */
@Mapper
public interface MemberTransformer {

	MemberTransformer INSTANCE = Mappers.getMapper(MemberTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.bornon", dateFormat="dd/MM/yyyy",target="bornon"),
	})
	MemberDto toDto(Member entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<MemberDto> toDtos(List<Member> entities) throws ParseException;

    default MemberDto toLiteDto(Member entity) {
		if (entity == null) {
			return null;
		}
		MemberDto dto = new MemberDto();
		dto.setId( entity.getId() );
		return dto;
    }

	default List<MemberDto> toLiteDtos(List<Member> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<MemberDto> dtos = new ArrayList<MemberDto>();
		for (Member entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.firstname", target="firstname"),
		@Mapping(source="dto.lastname", target="lastname"),
		@Mapping(source="dto.bornon", dateFormat="dd/MM/yyyy",target="bornon"),
		@Mapping(source="dto.gender", target="gender"),
		@Mapping(source="dto.job", target="job"),
		@Mapping(source="dto.email", target="email"),
		@Mapping(source="dto.promoinp", target="promoinp"),
		@Mapping(source="dto.studiedsectorinp", target="studiedsectorinp"),
		@Mapping(source="dto.maritalstatus", target="maritalstatus"),
		@Mapping(source="dto.nameofspouse", target="nameofspouse"),
		@Mapping(source="dto.churchattended", target="churchattended"),
		@Mapping(source="dto.placeofresidence", target="placeofresidence"),
		@Mapping(source="dto.isepici", target="isepici"),
		@Mapping(source="dto.district", target="district"),
		@Mapping(source="dto.secteur", target="secteur"),
		@Mapping(source="dto.assemblee", target="assemblee"),
		@Mapping(source="dto.responsabilityinchuch", target="responsabilityinchuch"),
		@Mapping(source="dto.photo", target="photo"),
	})
    Member toEntity(MemberDto dto) throws ParseException;

    //List<Member> toEntities(List<MemberDto> dtos) throws ParseException;

}
