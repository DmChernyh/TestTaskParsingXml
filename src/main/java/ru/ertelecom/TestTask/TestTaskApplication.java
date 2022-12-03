package ru.ertelecom.TestTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.ertelecom.TestTask.init.InitConfig;
import java.sql.SQLException;

@SpringBootApplication
public class TestTaskApplication {

	public static void main(String[] args) throws SQLException {
		ApplicationContext app = SpringApplication.run(TestTaskApplication.class, args);
		app.getBean(InitConfig.class).init();
	}

}
