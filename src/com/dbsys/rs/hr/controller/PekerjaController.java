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
import com.dbsys.rs.lib.EntityRestMessage;
import com.dbsys.rs.lib.ListEntityRestMessage;
import com.dbsys.rs.lib.entity.Pegawai;
import com.dbsys.rs.lib.entity.Pekerja;

@Controller
@RequestMapping("/pekerja")
public class PekerjaController {

	@Autowired
	private PegawaiService pegawaiService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public EntityRestMessage<Pegawai> save(@RequestBody Pekerja pekerja) throws ApplicationException, PersistenceException {
		pekerja = (Pekerja)pegawaiService.save(pekerja);
		return EntityRestMessage.createPegawai(pekerja);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ListEntityRestMessage<Pekerja> getAll() throws ApplicationException, PersistenceException {
		List<Pekerja> list = pegawaiService.getPekerja();
		return ListEntityRestMessage.createListPekerja(list);
	}
}
