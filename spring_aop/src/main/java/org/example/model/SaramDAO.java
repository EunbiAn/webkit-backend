package org.example.model;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaramDAO  {

    public List<SaramDTO> selectAll(){
        System.out.println(">>> selectAll():List<SaramDTO> - SaramDAO 호출>");
        return null;
    }

    public SaramDTO selectOne(SaramDTO dto){
        System.out.println(">>> selectOne():SaramDTO - SaramDAO 호출");
        return  null;
    }

    public void insert(SaramDTO dto){
        System.out.println(">>> insert():void - SaramDAO 호출");
    }

    public void update(SaramDTO dto){
        System.out.println(">>> update():void - SaramDAO 호출");
    }

    public void delete(SaramDTO dto){
        System.out.println(">>> delete():void - SaramDAO 호출");
    }
}
