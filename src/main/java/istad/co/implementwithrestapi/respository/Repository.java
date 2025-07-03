package istad.co.implementwithrestapi.respository;

import java.util.List;

public interface Repository<T,I> {
    List<T> findAll();
    I save(T t);
    I delete(String uuid);
}
