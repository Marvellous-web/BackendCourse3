package com.stackroute.demo.sprint8.repository;

import com.stackroute.demo.sprint8.domain.UserModal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModal,Integer> {


}
