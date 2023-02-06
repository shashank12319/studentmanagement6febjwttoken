package com.wittybrains.studentmanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;


//public interface  UserRepository extends JpaRepository< User, Long> {
//	boolean existsByName(String name);
//}
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wittybrains.studentmanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

   
   boolean existsByName(@Param("name") String name);
    User findByEmail(String email);

}
