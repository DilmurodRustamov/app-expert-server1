package uz.developer.appexpertserver1.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.developer.appexpertserver1.entity.Role;
import uz.developer.appexpertserver1.entity.User;
import uz.developer.appexpertserver1.entity.enums.PersonType;
import uz.developer.appexpertserver1.repository.RoleRepository;
import uz.developer.appexpertserver1.repository.UserRepository;

import java.util.HashSet;
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.sql.init.mode}")
    private String modeInitial;



    @Override
    public void run(String... args) throws Exception {
        if (modeInitial.equals("always")){
            HashSet<Role> roles = new HashSet<>(roleRepository.findAll());

            userRepository.save(new User(
                    "Dilmurod",
                    "Rustamov",
                    "",
                    "+998965487957",
                    passwordEncoder.encode("Root_123"),
                    "111111111",
                    "dilmurod@mail.com",
                    PersonType.JURIDICAL,
                    roles
            ));
        }
    }
}
