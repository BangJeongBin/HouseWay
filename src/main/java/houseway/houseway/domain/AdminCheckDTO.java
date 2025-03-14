package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminCheckDTO {
    private String admin_password;
}
