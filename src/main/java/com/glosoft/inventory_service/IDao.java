package com.glosoft.inventory_service;


import java.util.List;
import java.util.Optional;

public interface IDao<T> {

    Optional<T> get(long id);
    List<T> getAll();
    void save(T t);
  /*  //TODO
    void update(T t, String[] params);
    void delete(T t);

   */
}
