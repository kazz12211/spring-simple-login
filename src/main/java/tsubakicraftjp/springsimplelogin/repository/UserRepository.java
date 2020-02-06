package tsubakicraftjp.springsimplelogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tsubakicraftjp.springsimplelogin.model.AuthUser;

@Repository
public interface UserRepository extends JpaRepository<AuthUser, Long> {

    public AuthUser findByUsername(String username);
}