package me.jihyun.springMVC.Repositories;

import me.jihyun.springMVC.Models.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/*
@DataJpaTest
리포지토리를 토함한 리포지토리와 관련한 Bean들만 등록하여 테스트 -> 슬라이싱 테스트

테스트 할 때에는 인메모리 데이터베이스가 필요함 -> h2 의존성 추가

    ps. @DataJpaTest 대신 @SpringBootTest를 사용하는 경우 통합 테스트가 됨
 */

@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di() throws SQLException {
        Account account = new Account();
        account.setUsername("jihyun");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account);

        assertThat(newAccount).isNotNull();

        Optional<Account> existingAccount = accountRepository.findByUsername(newAccount.getUsername());
        assertThat(existingAccount).isNotNull();

        Optional<Account> notExistingAccount = accountRepository.findByUsername("ji");
        assertThat(notExistingAccount).isNotNull();
    }

}