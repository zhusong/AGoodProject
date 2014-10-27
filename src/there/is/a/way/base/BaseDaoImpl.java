package there.is.a.way.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {	
	
	protected Class<T> clazz; // 这是�?��问题�?
	@Resource  
    public void setSessionFacotry(SessionFactory sessionFacotry) {  
        super.setSessionFactory(sessionFacotry);  
    }  
	public BaseDaoImpl() {
		// 通过反射得到T的真实类�?
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) pt.getActualTypeArguments()[0];		
	}

	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}

	public void update(T entity) {
		
	}

	public void delete(Long id) {
		
	}

	public T getById(Long id) {
		return null;
	}

	public List<T> getByIds(Long[] ids) {
		return null;
	}

	public List<T> findAll() {
		return null;
	}




}
