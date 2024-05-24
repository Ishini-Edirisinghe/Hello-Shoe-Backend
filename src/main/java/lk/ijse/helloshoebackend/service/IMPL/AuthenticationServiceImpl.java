package lk.ijse.helloshoebackend.service.IMPL;

import lk.ijse. helloshoebackend.conversion.ConversionData;
import lk.ijse.helloshoebackend.dto.UserDTO;
import lk.ijse.helloshoebackend.entity.UserEntity;
import lk.ijse.helloshoebackend.repository.UserServiceDAO;
import lk.ijse. helloshoebackend.secureAndResponse.response.JwtAuthResponse;
import lk.ijse.helloshoebackend.secureAndResponse.secure.SignIn;
import lk.ijse.helloshoebackend.secureAndResponse.secure.SignUp;
import lk.ijse.helloshoebackend.service.AuthenticationService;
import lk.ijse.helloshoebackend.service.JwtService;
import lk.ijse.helloshoebackend.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final ConversionData conversionData;
    private final UserServiceDAO userDao;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthResponse signUp(SignUp signUp) {
        UserDTO userDTO = UserDTO.builder()
                .id(UtilMatters.generateId())
                .email(signUp.getEmail())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(signUp.getRole())
                .build();
        UserEntity saveUser = userDao.save(conversionData.toUserEntity(userDTO));
        String generateToken = jwtService.generateToken(saveUser);
        return JwtAuthResponse.builder().token(generateToken).build();
    }

    @Override
    public JwtAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword())
        );
        UserEntity user = userDao.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generateToken = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(generateToken).build();
    }

    @Override
    public JwtAuthResponse refreshToken(String refreshToken) {
        var userEntity = userDao
                .findByEmail(jwtService.extractUserName(refreshToken))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return JwtAuthResponse.builder().
                token(jwtService.generateToken(userEntity)).build();
    }
}
