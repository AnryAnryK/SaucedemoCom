package MestoPraktikumApiTests.models.lombok;

import lombok.Builder;
import lombok.Data;

//@Builder
@Data
public class LoginBodyModelLombok {
    String email, password;
}
