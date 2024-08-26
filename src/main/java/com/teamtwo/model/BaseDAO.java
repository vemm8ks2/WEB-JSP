package com.teamtwo.model;

import java.util.List;

/**
 * 앞으로 작성될 DAO는 해당 인터페이스를 구현합니다. 기본적인 CRUD를 구현하는 것을 전제로 진행합니다.
 * 
 * @author Kim
 * @param <T>
 */
public interface BaseDAO<T> {
	
	T get(int id);
    
    List<T> getAll();
    
    void save(T t);
    
    void update(T t, String[] params);
    
    void delete(T t);
}
