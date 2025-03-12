package houseway.houseway.repository.admin;

import houseway.houseway.domain.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface EstateAdminRepository {

    // 모든 매물 수
    @Select("select count(estate_id) from estate")
    int countEstate();

    // 매물 리스트
    @Select("select estate_id, agent_num, estate_title, estate_addr, estate_deposit, estate_rent, estate_viewCount, estate_state from estate order by estate_id desc limit #{strnum}, #{pageSize}")
    List<EstateListDTO> estateList(int strnum, int pageSize);

    // 매물 사진 리스트
    @Select("select * from image")
    List<Image> estateImageList();

    // 해당 매물 상세 정보
    @Select("select * from estate where estate_id = #{estate_id}")
    Estate selectOneEstate(String estateId);

    // 해당 매물 사진들
    @Select("select * from image where estate_id = #{estate_id}")
    Image selectEstateImages(String estateId);

    // 해당 매물 예약 상태
    @Select("select * from reserv where estate_id = #{estate_id}")
    Reserv selectEstateReservState(String estateId);

    // 해당 매물 북마크 목록
    @Select("select * from bookmark where estate_id = #{estate_id}")
    List<Bookmark> selectEstateBookmark(String estateId);



    // 매물 검색을 위한 카운트 메서드 - mapper
    int countFindEstate(Map<String, Object> params);

    // 매물 검색(페이지네이션) - mapper
    List<EstateListDTO> selectFindEstate(Map<String, Object> params);
}
