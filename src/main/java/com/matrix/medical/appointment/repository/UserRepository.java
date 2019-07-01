package com.matrix.medical.appointment.repository;

import com.matrix.medical.appointment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByConfirmationCode(String confirmationCode);
}
