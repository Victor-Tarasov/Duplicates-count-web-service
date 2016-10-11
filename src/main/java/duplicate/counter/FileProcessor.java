package duplicate.counter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author Victor Tarasov
 */
@Service
public class FileProcessor {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	public void initDb() throws SQLException {
		try(Connection connection = dataSource.getConnection()) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("create  table Files (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, NAME VARCHAR(255) NOT NULL, CONTENT LONGTEXT NOT NULL)");
			statement.executeUpdate("create  table Requests (ID INT PRIMARY KEY AUTO_INCREMENT, FILE_ID INT )");
		}

	}

	/**
	 * Save files to database.
	 *
	 * @return request id by witch parse result can be obtained.
	 */
	public List<Long> saveFiles(List<MultipartFile> files) throws IOException, SQLException {
		List<Long> ids = new ArrayList<>();
		try(Connection connection = dataSource.getConnection()) {
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			for (int i = 0; i < files.size(); i++) {
				statement.addBatch("");
			}
			statement.executeBatch();

			ResultSet generatedKeys = statement.getGeneratedKeys();
			while (generatedKeys.next()) {
				ids.add(generatedKeys.getLong(1));
			}
		}
		return ids;
	}


}
