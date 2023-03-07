package com.comstudy.boardweb.persistence;

import com.comstudy.boardweb.domain.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}
