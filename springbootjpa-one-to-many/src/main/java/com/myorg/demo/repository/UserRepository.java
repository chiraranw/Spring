/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.demo.repository;

import com.myorg.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chiraran
 * @Date Sep 27, 2019
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User WHERE username=?1")
    public User getUserByUsername(String usename);

}
