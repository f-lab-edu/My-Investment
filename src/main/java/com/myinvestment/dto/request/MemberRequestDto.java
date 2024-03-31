package com.myinvestment.dto.request;





import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberRequestDto {

    @NotBlank(message = "이메일은 필수 입력 값 입니다.")
    private String email;

    private String nickName;

    @NotBlank(message = "비밀번호는 필수 입력 값 입니다.")
    private String password;

    public MemberRequestDto(String email, String nickName, String password) {
        this.email = email;
        this.nickName = nickName;
        this.password = password;
    }
    public void setEncodedPwd(String encodedPwd) {
        this.password = encodedPwd;
    }

}
