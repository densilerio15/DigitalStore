package com.pccw.digitalstore.UserService.Services;

import org.springframework.stereotype.Service;

import com.pccw.digitalstore.UserService.Model.User;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public User getUserByUsername(String UserName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createNewUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserByFacialRecognition(String FacialRecognitionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByQrCode(String qrCodeId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
