package lk.ijse.helloshoebackend.service;

import lk.ijse.helloshoebackend.secureAndResponse.response.JwtAuthResponse;
import lk.ijse.helloshoebackend.secureAndResponse.secure.SignIn;
import lk.ijse.helloshoebackend.secureAndResponse.secure.SignUp;


public interface AuthenticationService {
    JwtAuthResponse signUp(SignUp signup);
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse refreshToken(String refreshToken);
}
