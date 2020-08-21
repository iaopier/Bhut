package com.apicarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apicarros.model.DAOLog;

@Repository
public interface LogRepository extends JpaRepository<DAOLog,Long>{

}
