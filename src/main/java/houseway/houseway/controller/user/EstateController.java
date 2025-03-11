package houseway.houseway.controller.user;

import houseway.houseway.domain.Estate;
import houseway.houseway.domain.EstateListDTO;
import houseway.houseway.service.user.EstateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/estate")
@RequiredArgsConstructor
public class EstateController {

    private final EstateService estateService;

    @GetMapping("/list")
        public String listEstates(Model model) {
        System.out.print("list 진입:::");
        // estateService에서 모든 estate 리스트를 가져옵니다
        List<Estate> estateList = estateService.getAllEstates();

        System.out.print(estateList);
        // estate 리스트를 Thymeleaf 템플릿에 전달
        model.addAttribute("estates", estateList);

        return "views/user/search";
    }

    @GetMapping("/search")
    public String searchEstates(@RequestParam(defaultValue = "all") String findtype,
                                @RequestParam(defaultValue = "all" ) String findkey,
                                Model model){
        List<EstateListDTO> estates = null;

        if (findkey.equals("all") || findkey.trim().isEmpty()) {
            // 검색어가 없으면 전체 매물 조회
            estates = estateService.searchEstates(null, null);
        } else {
            // 검색어가 있으면 해당 조건으로 검색
            estates = estateService.searchEstates(findtype, findkey);
        }

        model.addAttribute("estates", estates);

         return "views/user/search";  // 검색 결과를 표시할 뷰로 이동
    }

    @GetMapping("/estateDetail")
    public String estateDetail(Model model, @RequestParam("estate_id") String estate_id,
                               @RequestParam("agent_num") int agent_num) {

        System.out.println(agent_num);

        Estate estate = estateService.getEstateById(estate_id);
        List<Estate> estateList = estateService.getAllEstates();
        model.addAttribute("estates", estateList);
        model.addAttribute("estate", estate);

        // 해당 매물 상세 페이지에 해당하는 agnet 정보 추출
        model.addAttribute("agentDto", estateService.getEstateByAgent(agent_num));

       return "views/user/estateDetail";
    }

/*
    @GetMapping("/reservation")
    public String reservation(Model model, @RequestParam("estate_id") String estate_id) {

        Estate estate = estateService.getEstateById(estate_id);

        model.addAttribute("estate", estate);
        model.addAttribute("estateName", estate.getEstate_title());
        */
/*model.addAttribute("officeName",);*//*


        return "views/user/reservation";
    }
*/

}
