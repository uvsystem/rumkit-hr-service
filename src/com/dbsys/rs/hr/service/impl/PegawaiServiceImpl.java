package com.dbsys.rs.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbsys.rs.hr.repository.PegawaiRepository;
import com.dbsys.rs.hr.service.PegawaiService;
import com.dbsys.rs.lib.entity.Apoteker;
import com.dbsys.rs.lib.entity.Dokter;
import com.dbsys.rs.lib.entity.Pegawai;
import com.dbsys.rs.lib.entity.Pekerja;
import com.dbsys.rs.lib.entity.Perawat;

@Service
@Transactional(readOnly = true)
public class PegawaiServiceImpl implements PegawaiService {

	@Autowired
	private PegawaiRepository pegawaiRepository;
	
	@Override
	@Transactional(readOnly = false)
	public Pegawai save(Pegawai pegawai) {
		return pegawaiRepository.save(pegawai);
	}

	@Override
	public List<Dokter> getDokter() {
		return pegawaiRepository.findAllDokter();
	}

	@Override
	public List<Perawat> getPerawat() {
		return pegawaiRepository.findAllPerawat();
	}

	@Override
	public List<Apoteker> getApoteker() {
		return pegawaiRepository.findAllApoteker();
	}

	@Override
	public List<Pekerja> getPekerja() {
		return pegawaiRepository.findAllPekerja();
	}
}
