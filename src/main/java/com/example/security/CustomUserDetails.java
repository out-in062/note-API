package com.example.security;

import jakarta.annotation.Nullable;
import org.apache.catalina.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // ユーザーが持つ権限（ロール）を返します。必要に応じてDBなどの値から変換してください
        return Collections.emptyList();
    }

    @Override
    public @Nullable String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // アカウントの有効期限が切れていないかどうか（true: 期限内）
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // アカウントがロックされていないかどうか（true: ロックされていない）
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 資格情報（パスワード）の有効期限が切れていないかどうか（true: 期限内）
        return true;
    }

    @Override
    public boolean isEnabled() {
        // アカウントが有効かどうか（true: 有効）
        return true;
    }
}
