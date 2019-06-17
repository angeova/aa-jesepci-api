package ci.gcorp.aajesepci.utils.dto.transformer;

import ci.gcorp.aajesepci.dao.entity.User;
import ci.gcorp.aajesepci.utils.dto.UserDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-17T13:17:35+0000",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)
public class UserTransformerImpl implements UserTransformer {

    @Override
    public UserDto toDto(User entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        if ( entity.getCreatedAt() != null ) {
            userDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getBornOn() != null ) {
            userDto.setBornOn( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getBornOn() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            userDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        userDto.setId( entity.getId() );
        userDto.setLogin( entity.getLogin() );
        userDto.setPassword( entity.getPassword() );
        userDto.setFirstName( entity.getFirstName() );
        userDto.setLastName( entity.getLastName() );
        userDto.setLocked( entity.getLocked() );
        userDto.setIsSuperAdmin( entity.getIsSuperAdmin() );
        userDto.setIsDeleted( entity.getIsDeleted() );

        return userDto;
    }

    @Override
    public List<UserDto> toDtos(List<User> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( entities.size() );
        for ( User user : entities ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    @Override
    public User toEntity(UserDto dto) throws ParseException {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( dto.getFirstName() );
        user.setLastName( dto.getLastName() );
        if ( dto.getCreatedAt() != null ) {
            user.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
        }
        user.setPassword( dto.getPassword() );
        if ( dto.getBornOn() != null ) {
            user.setBornOn( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getBornOn() ) );
        }
        user.setIsDeleted( dto.getIsDeleted() );
        user.setIsSuperAdmin( dto.getIsSuperAdmin() );
        user.setId( dto.getId() );
        user.setLogin( dto.getLogin() );
        user.setLocked( dto.getLocked() );
        if ( dto.getUpdatedAt() != null ) {
            user.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
        }

        return user;
    }
}
