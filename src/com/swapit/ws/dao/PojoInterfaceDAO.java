package com.swapit.ws.dao;

import java.util.List;
import com.swapit.ws.dao.exception.ConnectException;

public interface PojoInterfaceDAO<T> {
	
	
	public List<T> listAll() throws ConnectException;
	public List<T> select(int id) throws ConnectException;
	public void update(T obj) throws ConnectException;
	public T save(T obj) throws ConnectException;
	public void delete(T obj) throws ConnectException;


}
