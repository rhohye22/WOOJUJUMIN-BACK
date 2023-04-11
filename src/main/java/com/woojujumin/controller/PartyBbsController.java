package com.woojujumin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.woojujumin.service.PartyBbsService;

@RestController
public class PartyBbsController {

	@Autowired
	PartyBbsService service;
}
