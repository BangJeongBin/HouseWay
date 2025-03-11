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


    // 매물 상세
    @GetMapping("/product_view/{estate_id}")
    public String productView(Model m, @PathVariable String estate_id) {
        m.addAttribute("estDto", estateAdminService.readOneProduct(estate_id));
        return "views/admin/estate/product_view";
    }
}
