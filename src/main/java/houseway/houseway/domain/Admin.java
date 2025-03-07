package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Admin {
    private String admin_id;
    private String admin_password;
    private String admin_name;
    private String admin_photo;
}
