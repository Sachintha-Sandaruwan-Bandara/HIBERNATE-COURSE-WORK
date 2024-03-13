package lk.ijse.HIBERNATE_COURSE_WORK.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    @author Sachi_S_Bandara
    @created 3/13/2024 - 5:58 PM 
*/
@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserAuthDTO {
    private boolean flag=false;
    private long id=-1L;
}
