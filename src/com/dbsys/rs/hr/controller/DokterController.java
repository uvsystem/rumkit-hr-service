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
import com.dbsys.rs.lib.entity.Dokter;
import com.dbsys.rs.lib.entity.Pegawai;

@Controller
@RequestMapping("/dokter")
public class DokterController {
	
	@Autowired
	private PegawaiService pegawaiService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public EntityRestMessage<Pegawai> save(@RequestBody Dokter dokter) throws ApplicationException, PersistenceException {
		dokter = (Dokter)pegawaiService.save(dokter);
		return EntityRestMessage.createPegawai(dokter);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ListEntityRestMessage<Dokter> getAll() throws ApplicationException, PersistenceException {
		List<Dokter> list = pegawaiService.getDokter();
		return ListEntityRestMessage.createListDokter(list);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/keyword/{keyword}")
	@ResponseBody
	public ListEntityRestMessage<Dokter> get(@PathVariable String keyword) throws ApplicationException, PersistenceException {
		List<Dokter> list = pegawaiService.getDokter(keyword);
		return ListEntityRestMessage.createListDokter(list);
	}
}
