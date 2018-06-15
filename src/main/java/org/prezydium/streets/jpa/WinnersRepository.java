package org.prezydium.streets.jpa;


import org.prezydium.streets.model.Winner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WinnersRepository extends JpaRepository<Winner, Long> {
}
