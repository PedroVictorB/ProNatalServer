package br.ufrn.pronatal.services;

import java.util.List;

import org.hibernate.Session;

import br.ufrn.pronatal.Util.HibernateUtil;
import br.ufrn.pronatal.models.Problem;

public class ProblemDAO {
	public boolean insertProblem(Problem m){
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
	
	public boolean deleteProblem(Problem m){
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
	
	public boolean updateProblem(Problem m){
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
	
	public boolean readProblem(int id){
		try{
			//Get Session
	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        //start transaction
	        session.beginTransaction();
	        //Save the Model object
	        session.get(Problem.class, id);
	        //Commit transaction
	        session.getTransaction().commit();

	        return true;
		}catch(Exception ex){
			return false;
		}
	}
	
	public List<Problem> readAllProblem(){
		try{
			//Get Session
	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        //start transaction
	        session.beginTransaction();
	        //Save the Model object
	        List<Problem> l = session.createCriteria(Problem.class).list();
	        //Commit transaction
	        session.getTransaction().commit();

	        return l;
		}catch(Exception ex){
			return null;
		}
	}
}
