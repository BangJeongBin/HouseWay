package houseway.houseway.controller.user;

import houseway.houseway.domain.*;
import houseway.houseway.repository.user.ReservRepository;
import houseway.houseway.service.user.EstateService;
import houseway.houseway.service.user.ReserveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("/estate")
@RequiredArgsConstructor
public class EstateController {

    private final EstateService estateService;
    private final ReserveService reserveService;
    private final ReservRepository reservRepository;

    @GetMapping("/list")
        public String listEstates(Model model) {

        // estateService에서 모든 estate 리스트를 가져옵니다
        List<Estate> estateList = estateService.getAllEstates();

        // estate 리스트를 Thymeleaf 템플릿에 전달
        model.addAttribute("estates", estateList);

        return "views/user/search";
    }

    @GetMapping("/search")
    public String searchEstates(@RequestParam(defaultValue = "all") String findtype,
                                @RequestParam(defaultValue = "all" ) String findkey,
                                Model model){
        List<EstateSearchListDTO> estates = null;

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
        EstateUserAllInfoDTO estateDto =  estateService.readOneUserEstate(estate_id, agent_num);

        model.addAttribute("estateDto", estateDto);

        System.err.println(estateDto);

        /*// 해당 매물 상세 페이지에 해당하는 agnet 정보 추출
        model.addAttribute("agentDto", estateService.getEstateByAgent(agent_num));*/

       return "views/user/estateDetail";
    }


    @GetMapping("/reservation")
    public String reservation(Model model, @RequestParam("estate_id") String estate_id) {

        Estate estate = estateService.getEstateById(estate_id);
        AgentDetailDTO agent = estateService.getEstateByAgent(estate.getAgent_num());


        model.addAttribute("estate", estate);
        model.addAttribute("estateName", estate.getEstate_title());
        model.addAttribute("agentDto", agent);


        return "views/user/reservation";
    }
    @PostMapping("/reservation")
    public String reservationOk(
                                @RequestParam("user_id") String user_id,
                                @RequestParam("estate_id") String estate_id,
                                @RequestParam("agent_num") int agent_num,
                                @RequestParam("agent_name") String agent_name,
                                @RequestParam("reserv_regdate") String reserv_regdateStr,
                                Model model) {


        try {
            // "yyyy-MM-dd HH:mm" 형식으로 변환
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime reserv_regdate = LocalDateTime.parse(reserv_regdateStr, formatter);

            // 예약 저장
            reserveService.saveReservation(user_id, estate_id, agent_num, agent_name, reserv_regdate);

            return "views/user/reserveOk"; // 성공 페이지로 이동

        } catch (Exception e) {
            e.printStackTrace();

            // 에러 시 다시 예약 입력 페이지로 리다이렉트
            return "redirect:/reservation";
        }
}
}