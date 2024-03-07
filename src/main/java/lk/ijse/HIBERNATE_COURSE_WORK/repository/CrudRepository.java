package lk.ijse.HIBERNATE_COURSE_WORK.repository;
/* 
    @author Sachi_S_Bandara
    @created 3/7/2024 - 10:07 PM 
*/

import java.util.List;

public interface CrudRepository<T,ID> extends SuperRepository{
    ID save(T object);

    void update(T object);

    T get(ID id);

    void delete(T object);

    List<T>getAll();
}
