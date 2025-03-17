package houseway.houseway.repository.user;

import houseway.houseway.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface EstateRepository {

    // 모든 매물 수
    @Select("select count(estate_id) from estate")
    int countEstate();

    @Select("select estate_id, estate_gu, estate_title, agent_num, estate_deposit, estate_rent from estate limit #{strnum},#{pageSize}")
    List<EstateUserListDTO> estateList(int strnum, int pageSize);


    @Select("select * from estate where estate_id = #{estate_id}")
    Estate getEstateById(String estate_id);

    @Select("SELECT a.* FROM estate e JOIN agent a ON e.agent_num = a.agent_num WHERE e.agent_num = #{agent_num} LIMIT 1")
    AgentDetailDTO estateByAgent(int agent_num);


    @Select("select * from image where estate_id =  #{estate_id}")
    Image estateImageOne(String estate_id);

    // 매물 검색을 위한 카운트 메서드 - mapper
    int countFindEstate(Map<String, Object> params);

    // 매물 검색(페이지네이션) - mapper
    List<EstateUserListDTO> selectFindUserEstate(Map<String, Object> params);

    @Select("select estate_id")
    List<EstateUserListDTO> EstateLocalList(int strnum, int pageSize);

}
