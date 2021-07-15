package me.jihyun.springMVC.Services;

import me.jihyun.springMVC.Models.Account;
import me.jihyun.springMVC.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/*
User를 관리하는 레이어는 UserDetailsService를 implement를 하도록 해야함
    -> UserDetailService Bean이 등록되기 때문에 Spring Security의 UserDetailsService Bean이
       등록되지 않음
    -> 우리가 코딩한 UserDetailsService에서 loadUserByUsername을 오버라이딩 함으로써 로그인을 처리함
    -> User가 자동생성되지 않음
 */
@Service
public class AccountSerivce implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account createAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password));

        return accountRepository.save(account);
    }

    /*
    loadUserByUsername
        1. 인자로 로그인 폼에서 입력한 username이 들어옴
        2. username으로 User 정보를 검색
        3. User의 password와 입력한 password를 비교
        4. 같으면 로그인 처리, 다르면 예외 던짐(로그인 폼에서 오류창이 뜸)
     */

    /*
    UserDetails
        유저 정보 클래스의 인터페이스이며, 기본 구현체는 org.springframework.security.core.userdetails.User로 제공한다.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> byUsername = accountRepository.findByUsername(username);
        Account account = byUsername.orElseThrow(() -> new UsernameNotFoundException(username));
        return new User(account.getUsername(), account.getPassword(), authorities());
    }

    private Collection<? extends GrantedAuthority> authorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
