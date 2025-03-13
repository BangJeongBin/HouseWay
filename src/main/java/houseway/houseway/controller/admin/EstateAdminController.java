package houseway.houseway.controller.admin;

import houseway.houseway.service.admin.EstateAdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class EstateAdminController {

    private final EstateAdminService estateAdminService;


    // 매물 리스트
    @GetMapping("/product")
    public String product(Model m, @RequestParam(defaultValue = "1") int cpg) {
        log.info("/admin/product 호출");
        m.addAttribute("estateDto", estateAdminService.readProduct(cpg));

        return "views/admin/estate/product";
    }


    // 매물 정렬 리스트
    @GetMapping("/product_sort")
    public String member(Model m, @RequestParam(defaultValue = "1") int cpg, @RequestParam("sno") int sno) {
        log.info("/admin/member_sort 호출");
        m.addAttribute("estateDto", estateAdminService.readSortEstate(cpg, sno));

        return "views/admin/estate/product";
    }


    // 매물 상세
    @GetMapping("/product_view/{estate_id}")
    public String productView(Model m, @PathVariable String estate_id) {
        m.addAttribute("estDto", estateAdminService.readOneProduct(estate_id));
        return "views/admin/estate/product_view";
    }


    // 매물 수정
    @GetMapping("/product_modify/{estate_id}")
    public String productModift(Model m, @PathVariable String estate_id) {
        m.addAttribute("estDto", estateAdminService.readOneProduct(estate_id));
        return "views/admin/estate/product_view";
    }


    // 매물 삭제
    @GetMapping("/product_remove")
    public String productRemove(Model m, @RequestParam("estate_id") String estate_id) {
        String returnUrl = "redirect:/admin/product_view/" + estate_id;

        if (estateAdminService.removeEstate(estate_id) > 0) {
            log.info(estate_id + "삭제 완료");
            returnUrl = "redirect:/admin/product";
        } else {
            log.info(estate_id + "삭제 실패");
        }
        return returnUrl;
    }


    // 매물 검색
    @GetMapping("/product_find")
    public String find(Model m, @RequestParam(defaultValue = "1") int cpg, String findtype, String findkey) {

        m.addAttribute("estateDto", estateAdminService.findEstate(cpg, findtype, findkey));

        return "views/admin/estate/product";
    }
}
