package com.woojujumin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.woojujumin.service.FreeBbsService;

@RestController
public class FreeBbsController {

	@Autowired
	FreeBbsService service;
	
}
