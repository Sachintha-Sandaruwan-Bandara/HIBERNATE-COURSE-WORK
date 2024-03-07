package lk.ijse.HIBERNATE_COURSE_WORK.dto;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 8:30 PM 
*/


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LibraryBranchDTO {
    private Long id;

    private String name;
    private String location;
    private List<BookDTO> books;

    @ManyToOne
    private AdminDTO admin;

}
