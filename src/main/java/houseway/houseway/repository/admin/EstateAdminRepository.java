package houseway.houseway.repository.admin;

import houseway.houseway.domain.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EstateAdminRepository {

    // 모든 매물 수
    @Select("select count(estate_id) from estate")
    int countEstate();

    // 매물 리스트
    @Select("select estate_id, estate_title, estate_addr, estate_deposit, estate_rent, estate_viewCount, estate_state from estate order by estate_id desc limit #{strnum}, #{pageSize}")
    List<EstateListDTO> estateList(int strnum, int pageSize);

    // 매물 사진 리스트
    @Select("select * from image")
    List<Image> estateImageList();
}
