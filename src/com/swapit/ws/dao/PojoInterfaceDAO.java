package com.swapit.ws.dao;

import java.util.List;
import com.swapit.ws.dao.exception.ConnectException;

public interface PojoInterfaceDAO<T> {
	
	
	public List<T> listAll() throws ConnectException;
	public T select(String id) throws ConnectException;
	public void update(T obj) throws ConnectException;
	public Boolean save(T obj) throws ConnectException;
	public void delete(T obj) throws ConnectException;


}
