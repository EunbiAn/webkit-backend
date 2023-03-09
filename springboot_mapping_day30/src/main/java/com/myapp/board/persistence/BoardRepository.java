package com.myapp.board.persistence;

import com.myapp.board.entity.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Integer> {
}
