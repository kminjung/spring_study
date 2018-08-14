package com.gura.spring03.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring03.cafe.dto.CafeCommentDto;

@Repository
public class CafeCommentDaoImpl implements CafeCommentDao{
	@Autowired
	private SqlSession session;

	@Override
	public int getSequence() {
		//새로 저장할 댓글의 글번호를 미리 얻어와서 : 댓글의 글 번호가 다른곳에서 처리 할 일이 있기 때문
		int seq=session.selectOne("cafeComment.getSequence");
		//리턴해 주기 
		return seq;
	}

	@Override
	public void insert(CafeCommentDto dto) {
		session.insert("cafeComment.insert", dto);
	}

	@Override
	public List<CafeCommentDto> getList(int ref_group) {
		
		return session.selectList("cafeComment.getList", ref_group);
	}


}

