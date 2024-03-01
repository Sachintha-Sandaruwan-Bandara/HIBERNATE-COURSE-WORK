package lk.ijse.HIBERNATE_COURSE_WORK.entity;

import javax.persistence.*;

/*
    @author Sachi_S_Bandara
    @created 3/1/2024 - 9:35 PM 
*/
@Entity
@Table(name = "library_branches")
public class LibraryBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchID;

    private String branchName;
    private String location;

    public LibraryBranch() {
    }

    public LibraryBranch(Long branchID, String branchName, String location) {
        this.branchID = branchID;
        this.branchName = branchName;
        this.location = location;
    }

    public Long getBranchID() {
        return branchID;
    }

    public void setBranchID(Long branchID) {
        this.branchID = branchID;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

