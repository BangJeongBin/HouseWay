package houseway.houseway.repository.admin;

import houseway.houseway.domain.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    // 정렬(view) 매물 리스트
    @Select("select estate_id, agent_num, estate_title, estate_addr, estate_deposit, estate_rent, estate_viewCount, estate_state from estate order by estate_viewCount desc limit #{strnum}, #{pageSize}")
    List<EstateListDTO> estateHitList(int strnum, int pageSize);

    // 정렬(state = 1) 매믈 리스트
    @Select("select estate_id, agent_num, estate_title, estate_addr, estate_deposit, estate_rent, estate_viewCount, estate_state from estate where estate_state = 1 order by estate_id desc limit #{strnum}, #{pageSize}")
    List<EstateListDTO> estateOnsaleList(int strnum, int pageSize);

    // 정렬(state = 0) 매믈 리스트
    @Select("select estate_id, agent_num, estate_title, estate_addr, estate_deposit, estate_rent, estate_viewCount, estate_state from estate where estate_state = 0 order by estate_id desc limit #{strnum}, #{pageSize}")
    List<EstateListDTO> estateUnsaleList(int strnum, int pageSize);

    // 매물 사진 리스트
    @Select("select * from image")
    List<Image> estateImageList();

    // 해당 매물 상세 정보
    @Select("select * from estate where estate_id = #{estateId}")
    Estate selectOneEstate(String estateId);

    // 해당 매물 사진들
    @Select("select * from image where estate_id = #{estateId}")
    Image selectEstateImages(String estateId);

    // 해당 매물 예약 상태
    @Select("select * from reserv where estate_id = #{estateId}")
    Reserv selectEstateReservState(String estateId);

    // 해당 매물 북마크 목록
    @Select("select * from bookmark where estate_id = #{estateId}")
    List<Bookmark> selectEstateBookmark(String estateId);

    // 매물 수정 확정
    @Update("update estate set estate_title = #{estate_title}, estate_desc = #{estate_desc}, estate_addr = #{estate_addr}, estate_gu = #{estate_gu}, estate_area = #{estate_area}, estate_amount = #{estate_amount}, estate_type = #{estate_type}, estate_service = #{estate_service}, estate_roomType = #{estate_roomType}, estate_parking = #{estate_parking}, estate_elev = #{estate_elev}, estate_moveDate = #{estate_moveDate}, estate_option = #{estate_option}, where estate_id = #{estate_id}")
    int updateEstateInfo(Estate estate);

    // 매물 삭제
    @Delete("delete from estate where eatate_id = #{estateId}")
    int deleteEstate(String estateId);

    // 매물 검색을 위한 카운트 메서드 - mapper
    int countFindEstate(Map<String, Object> params);

    // 매물 검색(페이지네이션) - mapper
    List<EstateListDTO> selectFindEstate(Map<String, Object> params);
}
