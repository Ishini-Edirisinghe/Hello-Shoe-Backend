package lk.ijse.helloshoebackend.service.IMPL;

import lk.ijse.helloshoebackend.repository.UserServiceDAO;
import lk.ijse.helloshoebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final private UserServiceDAO userDao;
    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userDao.findByEmail(username).
                        orElseThrow(()->new UsernameNotFoundException("User Not Found"));
    }
}
