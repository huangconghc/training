package jrx.data.report;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("jrx.data.report.mapper")
@ComponentScan(basePackages ={"jrx.data.report"})
public class DatareportApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatareportApplication.class, args);
	}

}
