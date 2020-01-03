package com.project.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Model.BeanFile;
import com.project.Model.CommentsModel;
import com.project.RegisterRepository.CommentsRepository;
import com.project.RegisterRepository.RegisterRepository;

@Service
public class Register implements RegisterService {

	@Autowired
	RegisterRepository respository;
	@Autowired
	CommentsRepository commentsRepository;

	@Override
	public void registerNewUser(BeanFile rd) {
		respository.save(rd);
	}

	public Iterable<BeanFile> forLogin(String name, String pass) {
		return respository.loginCheck(name, pass);
	}
	public Iterable<BeanFile> forForgotPassword(String name, String mail) {
		return respository.loginCheck(name, mail);
	}
	public int updateAdress(String mail,String pass) {
		return respository.updateAddress(mail, pass);	
		}

	public Iterable<CommentsModel> idFlow(int id) {
		return commentsRepository.alwaysLogin(id);
	}

	public void insertComments(CommentsModel commentsModel) {
		commentsRepository.save(commentsModel);
	}
	//public ArrayList<CommentsModel> individualUser(String name){
	//	return commentsRepository.invidualUser(name);
		
	//}
	

	public ArrayList individualUser(ArrayList<CommentsModel> name) {
		// TODO Auto-generated method stub
		return commentsRepository.invidualUser(name);
	}
	
	
   }
