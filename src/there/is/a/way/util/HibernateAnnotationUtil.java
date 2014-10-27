package there.is.a.way.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
/**
   	Description: configuration and session create.
   	@author sopher
   	@version 1.0.0
   	@Create Date 2014-09-29
   	Time 9:40 A.M;
  
 */
public class HibernateAnnotationUtil {
	/**create a final field session factory*/
	public static final SessionFactory sessionFactory;
	static{
		try{
			Configuration configuration = new AnnotationConfiguration().configure();// create a configuration
			sessionFactory = configuration.buildSessionFactory();//create a sessionFactory
		}catch( Throwable ex ){
			System.err.println( "Initial SessionFactory creation field." + ex );
			throw new ExceptionInInitializerError( ex );
		}
	}
	/**create a  session list, it use to save the current session.*/
	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();
	
	/**
	 Function name: currentSession
	 Description: This method is use to get the current useful session.
     @author:Sopher	
	 @return Session
     @exception:HibernateException   	 
	 @Create Date: 2014-9-29
	 Time: 10:09 A.M	
					Firstly, we create a 'ThreadLocal' static field 'session' to save current session, it just like create a singleton class.
					To protect the session is only one, so,When we want to get the current session, it will be has two results, one is null,
					the other is the current session. When it is null, we use 'openSession' method to create a session, and put it into 'ThreadLocal',
					then return the session,but We should know what does 'ThreadLocal' mean...
					when it is not null, it means the current session is exist, so we can directly use it. 					
	 */
	public static Session currentSession() throws HibernateException {
		Session s = session.get(); //get the current session
		if( s == null ){ //if the current session is not exist, then open session.
			s = sessionFactory.openSession(); 			
			session.set(s);
		}
		return s; // return the current session.
	}
	/**
	 Function name: closeSession
	 Description: This method is use to close the current session.
     @author:Sopher		 
     @exception:HibernateException
	 @Create Date: 2014-9-29
	 Time: 10:28 A.M	
					Close the current session. First we get the current session, if it is not exist, then set the current session to null, if it is
					not null, then set the current session to null.
	 */
	public static void closeSession() throws HibernateException{
		Session s = session.get();
		if( s != null ){// if the current session is not null, then we should close it.
			s.close();
		}
		session.set(null);	// set the current session to null.	
	}	
}
