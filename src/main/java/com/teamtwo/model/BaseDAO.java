package com.teamtwo.model;

import java.util.List;

/**
 * 앞으로 작성될 DAO는 해당 인터페이스를 구현합니다. 기본적인 CRUD를 구현하는 것을 전제로 진행합니다.
 * 
 * @author vemm8ks2
 * @param <T>
 */
public interface BaseDAO<T> {

  /**
   * T 타입 데이터의 식별자를 인자로 받아서 해당하는 데이터를 가져옵니다.
   * 
   * @param T 타입 객체의 식별자를 인자로 받습니다.
   * @return T 타입 객체의 DTO를 반환합니다.
   * @author vemm8ks2
   */
  T get(int id);

  /**
   * T 타입의 모든 데이터를 불러옵니다.
   * 
   * @author vemm8ks2
   */
  List<T> getAll();

  /**
   * T 타입의 DTO를 인자로 받아서 새롭게 저장하는 메소드입니다.
   * 
   * @param T 타입의 DTO 객체를 인자로 받습니다.
   * @author vemm8ks2
   */
  void save(T dto);

  /**
   * T 타입의 DTO를 인자로 받아서 인자의 데이터로 업데이트하는 메소드입니다.
   * 
   * @param T 타입의 DTO 객체를 인자로 받습니다.
   * @author vemm8ks2
   */
  void update(T dto);

  /**
   * T 타입 데이터의 식별자를 인자로 받아서 해당되는 주문을 삭제하는 메소드입니다.
   * 
   * @param T 타입 데이터의 식별자를 인자로 받습니다.
   * @author vemm8ks2
   */
  void delete(int id);
}
