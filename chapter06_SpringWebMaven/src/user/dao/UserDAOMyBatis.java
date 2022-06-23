package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

@Transactional
@Repository
public class UserDAOMyBatis implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
	}
	
	@Override
	public List<UserDTO> getAllUser() {
		return sqlSession.selectList("userSQL.getUserList");
	}
	
	@Override
	public UserDTO getUserById(String searchId) {
		return sqlSession.selectOne("userSQL.getUserOne", searchId);
	}
	
	@Override
	public void deleteUserById(String deleteId) {
		System.out.println("myBatis delete 호출! " + deleteId);
		
		sqlSession.delete("userSQL.delete",deleteId);
	}
	
	
	@Override
	public void updateUser(Map<String, String> map) {
		System.out.println("\n mybatis update 호출!" + map.get("id")+ map.get("name")+ map.get("pwd"));
		
		sqlSession.update("userSQL.updateUser", map);
		
		
	}
	
	
	
	
	//sqlSession.close() 안해요?? transaction Manager가 해준다.
	//class에 @Transactional 에 달아줘서 모든 sqlSession에 모두 관여하게 된다. 
	//application context xml 에 transactional 어노테이션 사용하고 있다고 알려줘야 한다.
}
