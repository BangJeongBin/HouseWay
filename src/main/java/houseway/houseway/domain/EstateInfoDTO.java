package houseway.houseway.domain;

import lombok.Data;

import java.util.List;

@Data
public class EstateInfoDTO {

    private Estate estateAllInfo;
    private Image estateImages;
    private Reserv estateReservState;
    private List<Bookmark> estateBookmarkList;

    public EstateInfoDTO(Estate estateAllInfo, Image estateImages, Reserv estateReservState, List<Bookmark> estateBookmarkList) {
        this.estateAllInfo = estateAllInfo;
        this.estateImages = estateImages;
        this.estateReservState = estateReservState;
        this.estateBookmarkList = estateBookmarkList;
    }
}
