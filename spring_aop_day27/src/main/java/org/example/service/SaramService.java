package org.example.service;

import org.example.model.SaramDTO;

import java.util.List;

public interface SaramService {
    List<SaramDTO> selectAll();

    SaramDTO selectOne(SaramDTO dto);

    void insert(SaramDTO dto);

    void update(SaramDTO dto);

    void delete(SaramDTO dto);

}
