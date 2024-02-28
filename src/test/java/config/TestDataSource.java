package config;

import javax.sql.DataSource;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

/**
 * TestDataSource.
 *
 * <p>
 *	테스트용 DataSource 관리
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/02/28
 */
@TestConfiguration
public class TestDataSource {

	@Bean
	@Primary
	public DataSource testDataSource() {
		return new SingleConnectionDataSource("jdbc:mysql://localhost/tobby", "tobby",
			"Hello@1234", true);
	}
}
