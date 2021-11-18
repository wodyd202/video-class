package com.ljy.videoclass.services.user.domain.value;

import com.ljy.videoclass.services.user.domain.exception.InvalidEmailException;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Email {
    private final String email;

    protected Email(){email = null;}

    public Email(String email) {
        if(email.isEmpty()){
            throw new InvalidEmailException("사용자 이메일을 입력해주세요.");
        }
        this.email = email;
    }

    public static Email of(String email){
        return new Email(email);
    }

    public String get() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}