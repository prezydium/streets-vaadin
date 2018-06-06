package org.prezydium.streets.jpa;


import org.prezydium.streets.model.Winner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WinnersRepository extends JpaRepository<Winner, Long> {
}
