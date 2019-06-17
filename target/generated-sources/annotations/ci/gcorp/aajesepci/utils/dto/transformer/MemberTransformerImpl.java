package ci.gcorp.aajesepci.utils.dto.transformer;

import ci.gcorp.aajesepci.dao.entity.Member;
import ci.gcorp.aajesepci.utils.dto.MemberDto;
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
public class MemberTransformerImpl implements MemberTransformer {

    @Override
    public MemberDto toDto(Member entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        MemberDto memberDto = new MemberDto();

        if ( entity.getBornon() != null ) {
            memberDto.setBornon( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getBornon() ) );
        }
        memberDto.setId( entity.getId() );
        memberDto.setFirstname( entity.getFirstname() );
        memberDto.setLastname( entity.getLastname() );
        memberDto.setGender( entity.getGender() );
        memberDto.setJob( entity.getJob() );
        memberDto.setEmail( entity.getEmail() );
        memberDto.setPromoinp( entity.getPromoinp() );
        memberDto.setStudiedsectorinp( entity.getStudiedsectorinp() );
        memberDto.setMaritalstatus( entity.getMaritalstatus() );
        memberDto.setNameofspouse( entity.getNameofspouse() );
        memberDto.setChurchattended( entity.getChurchattended() );
        memberDto.setPlaceofresidence( entity.getPlaceofresidence() );
        memberDto.setIsepici( entity.getIsepici() );
        memberDto.setDistrict( entity.getDistrict() );
        memberDto.setSecteur( entity.getSecteur() );
        memberDto.setAssemblee( entity.getAssemblee() );
        memberDto.setResponsabilityinchuch( entity.getResponsabilityinchuch() );
        memberDto.setPhoto( entity.getPhoto() );

        return memberDto;
    }

    @Override
    public List<MemberDto> toDtos(List<Member> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<MemberDto> list = new ArrayList<MemberDto>( entities.size() );
        for ( Member member : entities ) {
            list.add( toDto( member ) );
        }

        return list;
    }

    @Override
    public Member toEntity(MemberDto dto) throws ParseException {
        if ( dto == null ) {
            return null;
        }

        Member member = new Member();

        member.setFirstname( dto.getFirstname() );
        if ( dto.getBornon() != null ) {
            member.setBornon( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getBornon() ) );
        }
        member.setGender( dto.getGender() );
        member.setPhoto( dto.getPhoto() );
        member.setStudiedsectorinp( dto.getStudiedsectorinp() );
        member.setNameofspouse( dto.getNameofspouse() );
        member.setLastname( dto.getLastname() );
        member.setSecteur( dto.getSecteur() );
        member.setResponsabilityinchuch( dto.getResponsabilityinchuch() );
        member.setPromoinp( dto.getPromoinp() );
        member.setMaritalstatus( dto.getMaritalstatus() );
        member.setChurchattended( dto.getChurchattended() );
        member.setIsepici( dto.getIsepici() );
        member.setDistrict( dto.getDistrict() );
        member.setAssemblee( dto.getAssemblee() );
        member.setId( dto.getId() );
        member.setPlaceofresidence( dto.getPlaceofresidence() );
        member.setJob( dto.getJob() );
        member.setEmail( dto.getEmail() );

        return member;
    }
}
