package com.apicarros.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicarros.model.DAOLog;
import com.apicarros.repository.LogRepository;
import com.apicarros.service.LogService;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	LogRepository logRepository;
	
	@Override
	public DAOLog save(DAOLog log) {
		logRepository.save(log);
		return log;
		
	}
	
	@Override
	public List<DAOLog> findAll() {
		return logRepository.findAll();
	}
}
