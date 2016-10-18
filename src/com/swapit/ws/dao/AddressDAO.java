package com.swapit.ws.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.swapit.ws.dao.exception.ConnectException;
import com.swapit.ws.entities.Address;

public class AddressDAO implements PojoInterfaceDAO<Address> {

	@Override
	public List<Address> listAll() throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}
	public Address select(String ID) throws ConnectException {

		return null;
	}

	public List<Address> getbyID(String addressID) throws ConnectException {
		EntityManager em = EntitiManager.getEntityManager();
		Query query = em.createNamedQuery("selectAddressID");
		query.setParameter("addressID",addressID);
		return query.getResultList();
	}

	@Override
	public Boolean update(Address obj) throws ConnectException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean save(Address obj) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Address obj) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
		
	}

}
