package there.is.a.way.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import there.is.a.way.dao.UserDao;
import there.is.a.way.model.User;
import there.is.a.way.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;
	
	public void save(User entity) {
		userDao.save(entity);
		
	}

	public void delete(Long id) {		
		userDao.delete(id);
	}

	public void update(User entity) {
		
		userDao.update(entity);
	}

	public User getById(Long id) {
		
		return userDao.getById(id);
	}

	public List<User> getByIds(Long[] ids) {
		
		return userDao.getByIds(ids);
	}

	public List<User> findAll() {	
		return userDao.findAll();
	}
	
}
