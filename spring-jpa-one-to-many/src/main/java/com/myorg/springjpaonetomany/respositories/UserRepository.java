/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.springjpaonetomany.respositories;

import com.myorg.springjpaonetomany.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chiraran
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
