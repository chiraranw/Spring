/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.springjpaonetomany.respositories;

import com.myorg.springjpaonetomany.model.Authority;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chiraran
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    @Query("FROM Authority WHERE username=?1")
    public List<Authority> getAuthorityByUserName(String username);

    @Query("SELECT role FROM Authority  WHERE username=?1")
    public Set<String> getRolesByUserName(String username);

}
