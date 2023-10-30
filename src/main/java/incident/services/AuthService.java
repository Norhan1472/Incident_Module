package incident.services;

import java.net.SocketException;

import incident.payload.request.LoginRequest;
import incident.payload.response.LoginResponse;

public interface AuthService {

	public LoginResponse authenticateUser(LoginRequest loginRequest)throws SocketException;
	public void Logout();
	public String retUserName();


}
