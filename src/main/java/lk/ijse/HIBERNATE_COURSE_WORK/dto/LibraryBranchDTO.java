package lk.ijse.HIBERNATE_COURSE_WORK.dto;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 8:30 PM 
*/


import lk.ijse.HIBERNATE_COURSE_WORK.entity.Book;
import lk.ijse.HIBERNATE_COURSE_WORK.entity.LibraryBranch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LibraryBranchDTO {
    private Long id;

    private String name;
    private String location;

    @ManyToOne
    private AdminDTO admin;
    private List<BookDTO> books;


    public LibraryBranch toEntity() {
        LibraryBranch libraryBranch = new LibraryBranch();
        libraryBranch.setId(this.id);
        libraryBranch.setName(this.name);
        libraryBranch.setLocation(this.location);
        libraryBranch.setAdmin(this.admin.toEntity());
        List<Book> bookList = new ArrayList<>();
        for (BookDTO bookDto : this.books) {
            bookList.add(bookDto.toEntity());
        }
        libraryBranch.setBooks(bookList);
        return libraryBranch;
    }

}
