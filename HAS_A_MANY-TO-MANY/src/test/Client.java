package test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Courses;
import beans.Faculty;

public class Client {
	public static void main(String[] args) {
		
		Configuration cfg =new Configuration();
		cfg.configure("resources/Hibernate.cfg.xml");
		SessionFactory sf =cfg.buildSessionFactory();
		Session s  =sf.openSession();
		Transaction t = s.beginTransaction();
			

		Courses c1 =new Courses();
		c1.setCname("Core java");
		c1.setCfee(1500);
		c1.setCid(11);


		Courses c2 =new Courses();
		c2.setCname("J2EE");
		c2.setCfee(1500);
		c2.setCid(22);


		Courses c3 =new Courses();
		c3.setCname("Hibernate");
		c3.setCfee(1500);
		c3.setCid(33);


		Courses c4 =new Courses();
		c4.setCname("Spring");
		c4.setCfee(1500);
		c4.setCid(44);

	Set<Courses> cset = new HashSet<Courses>();
	cset.add(c1);
	cset.add(c2);
	
	Set<Courses> cset2 = new HashSet<Courses>();
	cset2.add(c1);
	cset2.add(c2);
	cset2.add(c3);
	
	Set<Courses> cset3 = new HashSet<Courses>();
	cset3.add(c1);
	cset3.add(c2);
	cset3.add(c3);
	cset3.add(c4);
	
	
	Faculty f1 = new Faculty();
	f1.setFid(1);
	f1.setFname("Keshav");
	f1.setYearex(8);
	f1.setCourses(cset);
	
	Faculty f2 = new Faculty();
	f2.setFid(2);
	f2.setFname("Praveen");
	f2.setYearex(14);
	f2.setCourses(cset2);
	
	Faculty f3 = new Faculty();
	f2.setFid(3);
	f2.setFname("Naveen");
	f2.setYearex(20);
	f2.setCourses(cset3);
	
	
	s.saveOrUpdate(f1);
	s.saveOrUpdate(f2);
	s.saveOrUpdate(f3);
	s.saveOrUpdate(c1);
	s.saveOrUpdate(c2);
	s.saveOrUpdate(c3);
	s.saveOrUpdate(c4);
	
	t.commit();
	System.out.println("insertion success in all three tables ;)");
	sf.close();
	
	
	}

}
