package me.kimchi.JwtTest.repository;

import me.kimchi.JwtTest.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    /*
    * userName으로 조회시 authorities 필드를 EAGER 조회
    * */
    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesByUsername(String username);
}
