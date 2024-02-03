package dao;

import java.util.List;

public interface ICrud<T> {
	int save(T t);
	List<T> getAll();
    T getById(int id);
    int deleteById(int id);
}
