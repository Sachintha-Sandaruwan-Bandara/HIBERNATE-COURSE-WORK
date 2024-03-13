package lk.ijse.HIBERNATE_COURSE_WORK.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    @author Sachi_S_Bandara
    @created 3/13/2024 - 5:59 PM 
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminAuthDTO {
    private boolean flag=false;
    private long id=-1L;
}
