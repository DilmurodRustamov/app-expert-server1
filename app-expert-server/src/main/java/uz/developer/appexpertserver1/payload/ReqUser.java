package uz.developer.appexpertserver1.payload;

import lombok.Data;
import uz.developer.appexpertserver1.entity.District;
import uz.developer.appexpertserver1.entity.Role;
import uz.developer.appexpertserver1.entity.enums.PersonType;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
public class ReqUser {

    @Pattern(regexp = "^[a-zA-Z]{3,20}$",message = "firstname and lastname must be 13 digits.")
    private String firstName, lastName;

    private String middleName;

    @Pattern(regexp = "^[+][9][9][8][0-9]{9}$",message = "Phone number must be 13 digits.")
    private String phoneNumber;

    @Pattern(regexp = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20})$", message = "Uzunligi 8-16 oralig'ida.Kamida bitta katta harf,son va belgi bo'lishi shart!")
//    ^(?:(?=.*?\p{N})(?=.*?[\p{S}\p{P} ])(?=.*?\p{Lu})(?=.*?\p{Ll}))[^\p{C}]{8,16}
    private String password;

    @Pattern(regexp = "^[0-9]{9}$",message = "TIN number must be 9 digits.")
    private String tin; //INN or STIR

    @Email(message = "wrong enter email")
    private String email;



}
