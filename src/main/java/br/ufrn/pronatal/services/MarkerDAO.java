package br.ufrn.pronatal.services;

import java.util.List;

import org.hibernate.Session;

import br.ufrn.pronatal.Util.HibernateUtil;
import br.ufrn.pronatal.models.Marker;

public class MarkerDAO {
	public boolean insertMarker(Marker m){
		try{
			//Get Session
	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        //start transaction
	        session.beginTransaction();
	        //Save the Model object
	        session.save(m);
	        //Commit transaction
	        session.getTransaction().commit();

	        return true;
		}catch(Exception ex){
			return false;
		}
	}
	
	public boolean deleteMarker(Marker m){
		try{
			//Get Session
	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        //start transaction
	        session.beginTransaction();
	        //Save the Model object
	        session.delete(m);
	        //Commit transaction
	        session.getTransaction().commit();

	        return true;
		}catch(Exception ex){
			return false;
		}
	}
	
	public boolean updateMarker(Marker m){
		try{
			//Get Session
	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        //start transaction
	        session.beginTransaction();
	        //Save the Model object
	        session.update(m);
	        //Commit transaction
	        session.getTransaction().commit();

	        return true;
		}catch(Exception ex){
			return false;
		}
	}
	
	public boolean readMarker(int id){
		try{
			//Get Session
	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        //start transaction
	        session.beginTransaction();
	        //Save the Model object
	        session.get(Marker.class, id);
	        //Commit transaction
	        session.getTransaction().commit();

	        return true;
		}catch(Exception ex){
			return false;
		}
	}
	
	public List<Marker> readAllMarker(){
		try{
			//Get Session
	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        //start transaction
	        session.beginTransaction();
	        //Save the Model object
	        List<Marker> l = session.createCriteria(Marker.class).list();
	        //Commit transaction
	        session.getTransaction().commit();

	        return l;
		}catch(Exception ex){
			return null;
		}
	}
}
