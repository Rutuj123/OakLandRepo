package com.matlab.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.matlab.entity.PersonPrefix;

@Repository
public class PrefixRepository {
	@Autowired
	private  SessionFactory sessionFactory;
	
		
		public void save(PersonPrefix prefix) {
			sessionFactory.getCurrentSession().save(prefix);
		}
		
		public List<PersonPrefix>  getAllPrefix(){
			return sessionFactory.getCurrentSession().createQuery("from PersonPrefix",PersonPrefix.class)
					.list();
		}
		
		public void delete(Long id) {
			PersonPrefix p=sessionFactory.getCurrentSession().get(PersonPrefix.class, id);
			sessionFactory.getCurrentSession().delete(p);
		}
}
