package anue.project1.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VideoDataFromDbMapper implements RowMapper<VideoDataFromDb> {
	@Override
	public VideoDataFromDb mapRow(ResultSet rs, int i) throws SQLException {
		VideoDataFromDb v = new VideoDataFromDb();
		v.setFiledA(rs.getString("FIELD_A"));
		v.setFiledB(rs.getString("FIELD_B"));
		v.setFiledC(rs.getString("FIELD_C"));
		return v;
	}
}
