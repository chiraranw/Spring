/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.springbootsecurity.repositories;

import com.myorg.springbootsecurity.model.Authority;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chiraran
 * @Date Sep 27, 2019
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    @Query("FROM Authority WHERE username=?1")
    public List<Authority> getAuthoritiesByUserName(String username);

}
