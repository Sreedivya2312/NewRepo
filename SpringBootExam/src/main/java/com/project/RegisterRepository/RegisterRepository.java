package com.project.RegisterRepository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Model.BeanFile;

@Repository
public interface RegisterRepository extends CrudRepository<BeanFile, Integer> {

	@Query("select C.id from BeanFile C where C.name= :name and C.pass=:pass")
	Iterable<BeanFile> loginCheck(@Param("name") String name, @Param("pass") String pass);

	@Query("select C.id from BeanFile C where C.name= :name and C.mail=:mail")
	Iterable<BeanFile> forgotPasswordCheck(@Param("name") String name, @Param("mail") String mail);

	@Transactional
	@Modifying
	@Query("UPDATE BeanFile c SET c.pass = :pass WHERE c.mail = :mail")
	int updateAddress(@Param("mail") String mail, @Param("pass") String pass);
	
	

}
