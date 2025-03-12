package houseway.houseway.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class EstateInfoDTO {

    private Estate estateAllInfo;
    private List<String> estateImages;
    private Reserv estateReservState;
    private List<Bookmark> estateBookmarkList;

    public EstateInfoDTO(Estate estateAllInfo, Image estateImages, Reserv estateReservState, List<Bookmark> estateBookmarkList) {
        this.estateAllInfo = estateAllInfo;
        this.estateImages = convertEstateImages(estateImages);
        this.estateReservState = estateReservState;
        this.estateBookmarkList = estateBookmarkList;
    }


    // image 테이블의 img1, img2...img n 컬럼을 리스트로 만드는 메서드
    private List<String> convertEstateImages(Image estateImages) {
        return Stream.of(
                        estateImages.getImg1(), estateImages.getImg2(), estateImages.getImg3(),
                        estateImages.getImg4(), estateImages.getImg5(), estateImages.getImg6(),
                        estateImages.getImg7(), estateImages.getImg8(), estateImages.getImg9()
                ).filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}
