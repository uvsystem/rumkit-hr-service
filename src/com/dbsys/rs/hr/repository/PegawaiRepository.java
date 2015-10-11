package com.dbsys.rs.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dbsys.rs.lib.entity.Apoteker;
import com.dbsys.rs.lib.entity.Dokter;
import com.dbsys.rs.lib.entity.Pegawai;
import com.dbsys.rs.lib.entity.Pekerja;
import com.dbsys.rs.lib.entity.Perawat;

public interface PegawaiRepository extends JpaRepository<Pegawai, Long> {

	/**
	 * Mengambil semua dokter.
	 * 
	 * @return daftar dokter
	 */
	@Query("FROM Dokter dokter")
	List<Dokter> findAllDokter();

	/**
	 * Mengambil semua perawat.
	 * 
	 * @return daftar perawat
	 */
	@Query("FROM Perawat perawat")
	List<Perawat> findAllPerawat();

	/**
	 * Mengambil semua apoteker.
	 * 
	 * @return daftar apoteker
	 */
	@Query("FROM Apoteker apoteker")
	List<Apoteker> findAllApoteker();

	/**
	 * Mengambil semua pekerja.
	 * 
	 * @return daftar pekerja
	 */
	@Query("FROM Pekerja pekerja")
	List<Pekerja> findAllPekerja();

}
