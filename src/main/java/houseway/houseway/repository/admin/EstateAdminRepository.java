package houseway.houseway.repository.admin;

import houseway.houseway.domain.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EstateAdminRepository {

    // 모든 회원 수
    @Select("select count(estate_id) from estate")
    int countEstate();

    // 회원 리스트
    @Select("select estate_id, estate_title, estate_addr, estate_deposit, estate_rent, estate_state from estate order by estate_id desc limit #{strnum}, #{pageSize}")
    List<EstateListDTO> estateList(int strnum, int pageSize);
}
