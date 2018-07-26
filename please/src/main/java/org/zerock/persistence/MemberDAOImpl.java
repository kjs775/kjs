package org.zerock.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namesapce = "org.zerock.persistence.MemberDAO";
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(namesapce+".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namesapce+".insertMember",vo);
	}
	
	@Override
	public MemberVO readMember(String userid) throws Exception{
		return (MemberVO)(sqlSession.selectOne(namesapce+".selectMember", userid));
	}
	
	@Override
	public MemberVO readWithPW(String userid, String pw)throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("userid", userid);
		paramMap.put("userpw", pw);
		
		return sqlSession.selectOne(namesapce+".readWithPW",paramMap);
	}
}
