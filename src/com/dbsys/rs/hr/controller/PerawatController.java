package com.dbsys.rs.hr.controller;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbsys.rs.hr.service.PegawaiService;
import com.dbsys.rs.lib.ApplicationException;
import com.dbsys.rs.lib.EntityRestMessage;
import com.dbsys.rs.lib.ListEntityRestMessage;
import com.dbsys.rs.lib.entity.Pegawai;
import com.dbsys.rs.lib.entity.Perawat;

@Controller
@RequestMapping("/perawat")
public class PerawatController {
	
	@Autowired
	private PegawaiService pegawaiService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public EntityRestMessage<Pegawai> save(@RequestBody Perawat perawat) throws ApplicationException, PersistenceException {
		perawat = (Perawat)pegawaiService.save(perawat);
		return EntityRestMessage.createPegawai(perawat);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ListEntityRestMessage<Perawat> getAll() throws ApplicationException, PersistenceException {
		List<Perawat> list = pegawaiService.getPerawat();
		return ListEntityRestMessage.createListPerawat(list);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/keyword/{keyword}")
	@ResponseBody
	public ListEntityRestMessage<Perawat> get(@PathVariable String keyword) throws ApplicationException, PersistenceException {
		List<Perawat> list = pegawaiService.getPerawat(keyword);
		return ListEntityRestMessage.createListPerawat(list);
	}
}
