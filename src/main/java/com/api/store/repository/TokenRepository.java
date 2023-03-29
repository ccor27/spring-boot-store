package com.api.store.repository;

import com.api.store.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {

    @Query(value = """
      select t from Token t inner join Customer c
      on t.customer.id = c.id
      where c.id = :id and (t.expired = false or t.revoked = false)
      """)
    List<Token> findAllValidTokenByCustomer(Long id);
    Optional<Token> findByToken(String token);
}
