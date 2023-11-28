package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.userdto;

public class userdao {
	EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=fac.createEntityManager();
	public void serveruser(userdto dto)
	{
		manager.getTransaction().begin();
	
		manager.persist(dto);
		
		manager.getTransaction().commit();
	}
	public userdto findbyemail(String email)
	{
		Query query= manager.createQuery("select a from userdto a where email=?1").setParameter(1, email);
		List<userdto> list=query.getResultList();
		if(!list.isEmpty())
			return list.get(0);
		else
			
		return null;
	}

}
