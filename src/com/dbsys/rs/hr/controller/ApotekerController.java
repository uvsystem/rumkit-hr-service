package com.dbsys.rs.hr.controller;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbsys.rs.hr.service.PegawaiService;
import com.dbsys.rs.lib.ApplicationException;
import com.dbsys.rs.lib.entity.Apoteker;
import com.dbsys.rs.lib.EntityRestMessage;
import com.dbsys.rs.lib.ListEntityRestMessage;
import com.dbsys.rs.lib.entity.Pegawai;

@Controller
@RequestMapping("/apoteker")
public class ApotekerController {

	@Autowired
	private PegawaiService pegawaiService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public EntityRestMessage<Pegawai> save(@RequestBody Apoteker apoteker) throws ApplicationException, PersistenceException {
		apoteker = (Apoteker)pegawaiService.save(apoteker);
		return EntityRestMessage.createPegawai(apoteker);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ListEntityRestMessage<Apoteker> getAll() throws ApplicationException, PersistenceException {
		List<Apoteker> list = pegawaiService.getApoteker();
		return ListEntityRestMessage.createListApoteker(list);
	}
}
