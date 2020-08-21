package com.apicarros.service;

import java.util.List;

import com.apicarros.model.DAOLog;

public interface LogService {

	DAOLog save(DAOLog log);

	List<DAOLog> findAll();

}
