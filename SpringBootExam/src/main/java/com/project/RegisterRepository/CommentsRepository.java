package com.project.RegisterRepository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.Model.CommentsModel;
import com.project.Model.BeanFile;

public interface CommentsRepository extends CrudRepository<CommentsModel, Integer> {
	@Query("select C.name from BeanFile C where C.id= :id")
	Iterable<CommentsModel> alwaysLogin(@Param("id") int id);
	
	@Query("select C.comments,C.username,C.id as ID from CommentsModel C where C.username=:name")
	ArrayList<String> invidualUser(@Param("name")ArrayList<CommentsModel> name);	
}
