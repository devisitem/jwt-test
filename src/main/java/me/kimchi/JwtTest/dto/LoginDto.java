package me.kimchi.JwtTest.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class LoginDto {

    @NotNull
    @Size(min = 4, max = 50)
    private String userName;

    @NotNull
    @Size(min = 4, max = 100)
    private String password;
}
