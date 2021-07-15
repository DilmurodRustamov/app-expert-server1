package uz.developer.appexpertserver1.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class ReqLogin {
    @NotBlank
    private String username;
    @Pattern(regexp = "^(?:(?=.*?\\p{N})(?=.*?[\\p{S}\\p{P} ])(?=.*?\\p{Lu})(?=.*?\\p{Ll}))[^\\p{C}]{8,16}$", message = "Uzunligi 8-16 oralig'ida.Kamida bitta katta harf,son va belgi bo'lishi shart!")


    private String password;
}
