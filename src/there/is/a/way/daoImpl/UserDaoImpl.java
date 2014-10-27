package there.is.a.way.daoImpl;

import org.springframework.stereotype.Repository;
import there.is.a.way.base.BaseDaoImpl;
import there.is.a.way.dao.UserDao;
import there.is.a.way.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	
}
