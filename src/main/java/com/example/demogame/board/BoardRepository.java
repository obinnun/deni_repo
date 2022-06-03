package com.example.demogame.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {


}
