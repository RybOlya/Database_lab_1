/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.controller
 * Interface: GeneralController
 **/

package ua.lviv.iot.controller;

import java.util.List;
import java.util.Optional;

public interface GeneralController<T, ID> {
    List<T> findAll();

    Optional<T> findById(ID id);

    int create(T entity);

    int update(ID id, T entity);

    int delete(ID id);
}
