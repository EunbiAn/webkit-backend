package org.comstudy.myapp.model;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
public class SaramDAO {
    // Database에 CRUD를 전담하는 클래스
    Connection conn = null; // 디비 연결 용도
    PreparedStatement stmt = null; // 디비에 SQL 전달
    ResultSet rs = null; // 결과를 받아 올때 사용.
    SqlSession session ;
    public void SaramDAO(){
        try {
            String resource = "org/comstudy/myapp/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    // 검색
    public List<SaramDTO> findAll() {
        List<SaramDTO> list = null;
        return list;
    }
    public SaramDTO findOne(SaramDTO dto) {
        SaramDTO saram = session.selectOne("org.comstudy.myapp.SaramMapper.findOne",dto.getSeq());
        return saram;
    }
    // 입력
    public void save(SaramDTO dto) {

    }
    // 수정
    public void update(SaramDTO dto) {

    }
    // 삭제
    public void remove(SaramDTO dto) {

    }

    public static void main(String[] args) {
        SaramDAO dao = new SaramDAO();
        SaramDTO dto = new SaramDTO(5,null,null,0);
        System.out.println(dao.findOne(dto));
    }
}