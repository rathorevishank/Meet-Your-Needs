package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Response;

import com.example.demo.repositories.ResponseRepository;

@Service
public class ResponseService {
	@Autowired
	ResponseRepository rep;

	public List<Response> getall() {
		return rep.findAll();
	}

	public Response getById(int rid) {
		return rep.getById(rid);
	}
	
	public Response addResp(Response res)
	{
		return rep.save(res);
	}
	
	public List<Response> getByReq(int id)
	{
		return rep.getByRequest(id);
	}
}
