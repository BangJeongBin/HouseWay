package houseway.houseway.domain;

import lombok.Data;

import java.util.List;

@Data
public class UserInfoDTO {

    private User userAllInfo;
    private List<Reserv> userReservList;
    private List<Sales> userSalesList;
    private List<Bookmark> userBookmarkList;

    public UserInfoDTO(User userAllInfo, List<Reserv> userReservList, List<Sales> userSalesList, List<Bookmark> userBookmarkList) {
        this.userAllInfo = userAllInfo;
        this.userReservList = userReservList;
        this.userSalesList = userSalesList;
        this.userBookmarkList = userBookmarkList;
    }
}
