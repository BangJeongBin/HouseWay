package houseway.houseway.repository.user;

import houseway.houseway.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EstateRepository {

    @Select("select * from estate order by estate_id desc")
    List<Estate> estateAllList();

    @Select("select estate_id, estate_title, estate_deposit, estate_rent from estate where estate_gu like CONCAT('%', #{findtype}, '%') " +
            " or estate_title like CONCAT('%', #{findkey}, '%') order by estate_id desc")
    List<EstateSearchListDTO> searchEstates(String findtype, String findkey);

    @Select("select estate_id, estate_title, estate_deposit, estate_rent from estate")
    List<EstateSearchListDTO> searchEstatesList();

    @Select("select * from estate where estate_id = #{estate_id}")
    Estate getEstateById(String estate_id);

    @Select("SELECT a.* FROM estate e JOIN agent a ON e.agent_num = a.agent_num WHERE e.agent_num = #{agent_num} LIMIT 1")
    AgentDetailDTO estateByAgent(int agent_num);


    @Select("select * from image where estate_id = #{estate_id}")
    Image estateImageOne(String estate_id);

}
