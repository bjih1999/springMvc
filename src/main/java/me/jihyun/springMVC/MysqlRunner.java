package me.jihyun.springMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class MysqlRunner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        try(Connection connection = dataSource.getConnection()){
//            System.out.println(connection.getMetaData().getURL());
//            System.out.println(connection.getMetaData().getUserName());
//            Statement statement = connection.createStatement();
//            String sql = "CREATE TABLE USER(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (ID));";
//            statement.executeUpdate(sql);
//        }
//
//        /*
//        jdbcTemplate을 사용하는 경우 리소스 반납을 위한 try catch를 해줄 필요 없이 코드를 줄일 수 있음
//        */
//        jdbcTemplate.execute("INSERT INTO USER VALUES(1, 'jih')");

    }
}
