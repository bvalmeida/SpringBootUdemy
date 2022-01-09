package com.br.springhibernate.repository;

import java.util.List;

import com.br.springhibernate.StatusRole;
import com.br.springhibernate.entity.Role;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findByStatus(StatusRole status);

    Page<Role> findAll(Pageable pageable);

}
