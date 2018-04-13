package  com.pccw.digitalstore.UserService.Services;

import com.pccw.digitalstore.UserService.Model.User;

public interface UserService{
	public User  getUserByUsername(String UserName);
	public void createNewUser(User  user);
	public User getUserByFacialRecognition(String FacialRecognitionId);
	public User getUserByQrCode(String qrCodeId);
	
}