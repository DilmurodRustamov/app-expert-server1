package uz.developer.appexpertserver1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.developer.appexpertserver1.entity.User;
import uz.developer.appexpertserver1.entity.enums.PersonType;
import uz.developer.appexpertserver1.entity.enums.RoleName;
import uz.developer.appexpertserver1.payload.ApiResponse;
import uz.developer.appexpertserver1.payload.ReqUser;
import uz.developer.appexpertserver1.repository.DistrictRepository;
import uz.developer.appexpertserver1.repository.RoleRepository;
import uz.developer.appexpertserver1.repository.UserRepository;

import java.util.Collections;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    public ApiResponse register(ReqUser reqUser){
        if (!userRepository.existsByPhoneNumber(reqUser.getPhoneNumber())){
            if (!userRepository.existsByEmailEqualsIgnoreCase(reqUser.getEmail())){
                if (!userRepository.existsByTin(reqUser.getTin())){
                    User user = new User(
                            reqUser.getFirstName(),
                            reqUser.getLastName(),
                            reqUser.getMiddleName(),
                            reqUser.getPhoneNumber(),
                            passwordEncoder.encode(reqUser.getPassword()),
                            reqUser.getTin(),
                            reqUser.getEmail(),
                            PersonType.PHYSICAL,
                            Collections.singleton(roleRepository.findByRoleName(RoleName.USER_ROLE))
                    );

                    userRepository.save(user);
                    return new ApiResponse(true,"saqlandi");
                }
                return new ApiResponse(false,"Tin mavjud");
            }
            return new ApiResponse(false,"email mavjud");
        }
        return new ApiResponse(false,"telefon raqam mavjud");
    }
}
