package be.relin;

import java.util.Date;
import org.hibernate.Session;
import be.relin.eatown.util.HibernateUtil;
import be.relin.eatown.bean.Utilisateurs;


//Create table DBUSER (
//		   USER_ID serial not null,
//		   USERNAME varchar(20) not null,
//		   FIRST_NAME varchar(25),
//		   LAST_NAME varchar(25),
//		   INSCRIPTION_DATE date not null
//		);
//insert into DBUSER (user_id, username, first_name, last_name, inscription_date) 
//VALUES (1, 'admin', 'Raphael', 'S', now());
public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
		Utilisateurs user = new Utilisateurs();
 
		user.setId(100);
		user.setFirst_name("Raphael");
		user.setLast_name("S");
		user.setUsername("Relin");
		user.setInscription(new Date());
 
		session.save(user);
		session.getTransaction().commit();
	}
}