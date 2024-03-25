package com.enigma.gymregistration.repository;

import com.enigma.gymregistration.constant.MemberStatus;
import com.enigma.gymregistration.model.entity.Role;
import com.enigma.gymregistration.model.entity.User;
import com.enigma.gymregistration.model.request.UserRequest;
import com.enigma.gymregistration.model.response.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Modifying
    @Query(value = "INSERT INTO t_user (id, username, email, password, role_id, member_status) VALUES (?, ?, ?, ?, ?, ?)", nativeQuery = true)
    void saveUser(String id, String username, String email, String password, String roleId, MemberStatus memberStatus);

    @Query(value = "SELECT * FROM t_user WHERE id = ?", nativeQuery = true)
    Optional<User> findUserById(String id);

    @Query(value = "SELECT * FROM t_user", nativeQuery = true)
    List<User> findAllUser();

}