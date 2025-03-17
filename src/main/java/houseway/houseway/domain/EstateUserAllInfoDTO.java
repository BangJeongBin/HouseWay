package houseway.houseway.domain;

import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class EstateUserAllInfoDTO {
    private Estate getEstateById;
    private AgentDetailDTO estateByAgent;
    private List<String> estateImageOne;


    public EstateUserAllInfoDTO(Estate getEstateById, AgentDetailDTO estateByAgent, Image estateImageOne) {
        this.getEstateById = getEstateById;
        this.estateByAgent = estateByAgent;
        this.estateImageOne = convertEstateImages(estateImageOne);
    }

    // image 테이블의 img1, img2...img n 컬럼을 리스트로 만드는 메서드
    private List<String> convertEstateImages(Image estateImageOne) {
        return Stream.of(
                        estateImageOne.getImg1(), estateImageOne.getImg2(), estateImageOne.getImg3(),
                        estateImageOne.getImg4(), estateImageOne.getImg5(), estateImageOne.getImg6(),
                        estateImageOne.getImg7(), estateImageOne.getImg8(), estateImageOne.getImg9()
                ).filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}