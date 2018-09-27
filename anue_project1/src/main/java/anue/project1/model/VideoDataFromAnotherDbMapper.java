package anue.project1.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VideoDataFromAnotherDbMapper implements RowMapper<VideoDataFromAnotherDb> {
	@Override
	public VideoDataFromAnotherDb mapRow(ResultSet rs, int i) throws SQLException {
		VideoDataFromAnotherDb v = new VideoDataFromAnotherDb();
		v.setFiledD(rs.getString("FIELD_D"));
		v.setFiledE(rs.getString("FIELD_E"));
		return v;
	}
}
