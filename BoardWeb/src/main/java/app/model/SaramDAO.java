package app.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

//클래스 선언 및 빈 등록
@Repository
public class SaramDAO {
    public ArrayList<SaramDTO> selectAll(){
        System.out.println("sellctAll() 호출");
        return null;
    }
}
