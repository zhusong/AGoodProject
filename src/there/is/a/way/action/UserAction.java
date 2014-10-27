package there.is.a.way.action;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import there.is.a.way.base.BaseAction;
import there.is.a.way.model.User;
import there.is.a.way.util.HibernateAnnotationUtil;
import there.is.a.way.util.HibernateTest;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	/**
	 * 
	 */
	public String login(){
		System.out.println( model.getUsername() + "," + model.getPassword() );
		User user = ( User )model;
		userService.save(user);		
		return SUCCESS;
	}
//	public String register(){
//		Session s = HibernateAnnotationUtil.currentSession();
//		Transaction tr = s.beginTransaction();			
//		s.save(model);
//		tr.commit();
//	
//		HibernateAnnotationUtil.closeSession();
//		return SUCCESS;
//	}

}
