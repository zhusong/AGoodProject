package there.is.a.way.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import there.is.a.way.model.User;



public class HibernateTest {
	public static void saveUser( User user ){
		Session s = HibernateAnnotationUtil.currentSession();
		Transaction tr = s.beginTransaction();			
		s.save(user);
		tr.commit();
	//	s.close();
		HibernateAnnotationUtil.closeSession();
	}
	public static void main(String[] args) {
		User user = new User();
		user.setUsername( "ddd" );
		user.setPassword( "dfdf" );
		saveUser( user );
	}
}
