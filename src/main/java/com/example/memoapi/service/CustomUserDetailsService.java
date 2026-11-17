package com.example.memoapi.service;

import com.example.memoapi.dto.User;
import com.example.memoapi.repository.UserRepository;
import com.example.memoapi.security.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // コンストラクタインジェクション（依存オブジェクトの注入）
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // データベースからユーザー名でユーザー情報を検索
        User user = userRepository.selectUserByUsername(username);

        // ユーザーが見つからない場合は例外（エラー）を投げる
        if (user == null) {
            throw new UsernameNotFoundException(username + " is not found");
        }

        // Spring Securityで扱えるCustomUserDetailsオブジェクトに詰めて返す
        return new CustomUserDetails(user);
    }
}
