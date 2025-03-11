package houseway.houseway.repository.user;

import houseway.houseway.domain.Agent;
import houseway.houseway.domain.Estate;
import houseway.houseway.domain.EstateListDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface EstateRepository {

    @Select("select * from estate order by estate_id desc")
    List<Estate> estateAllList();

    @Select("select estate_id, estate_title, estate_deposit, estate_rent from estate where estate_gu like CONCAT('%', #{findtype}, '%') " +
            " or estate_title like CONCAT('%', #{findkey}, '%') order by estate_id desc")
    List<EstateListDTO> searchEstates(String findtype, String findkey);

    @Select("select estate_id, estate_title, estate_deposit, estate_rent from estate")
    List<EstateListDTO> searchEstatesList();

    @Select("select * from estate where estate_id = #{estate_id}")
    Estate getEstateById(String estate_id);

    @Select("SELECT a.* FROM estate e JOIN agent a ON e.agent_num = a.agent_num where e.agent_num = #{agent_num}")
    Agent estateByAgent(int agent_num);
}
