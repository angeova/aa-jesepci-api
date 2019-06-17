

/*
 * Java transformer for entity table user 
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
 * TRANSFORMER for table "user"
 * 
 * @author Geo
 *
 */
@Mapper
public interface UserTransformer {

	UserTransformer INSTANCE = Mappers.getMapper(UserTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.bornOn", dateFormat="dd/MM/yyyy",target="bornOn"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
	})
	UserDto toDto(User entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<UserDto> toDtos(List<User> entities) throws ParseException;

    default UserDto toLiteDto(User entity) {
		if (entity == null) {
			return null;
		}
		UserDto dto = new UserDto();
		dto.setId( entity.getId() );
		dto.setLogin( entity.getLogin() );
		dto.setFirstName( entity.getFirstName() );
		dto.setLastName( entity.getLastName() );
		return dto;
    }

	default List<UserDto> toLiteDtos(List<User> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<UserDto> dtos = new ArrayList<UserDto>();
		for (User entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.login", target="login"),
		@Mapping(source="dto.password", target="password"),
		@Mapping(source="dto.firstName", target="firstName"),
		@Mapping(source="dto.lastName", target="lastName"),
		@Mapping(source="dto.bornOn", dateFormat="dd/MM/yyyy",target="bornOn"),
		@Mapping(source="dto.locked", target="locked"),
		@Mapping(source="dto.isSuperAdmin", target="isSuperAdmin"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
	})
    User toEntity(UserDto dto) throws ParseException;

    //List<User> toEntities(List<UserDto> dtos) throws ParseException;

}
