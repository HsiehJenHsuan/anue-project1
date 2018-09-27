package anue.project1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import anue.project1.model.VideoDataFromDb;
import anue.project1.model.VideoDataFromDbMapper;

@Repository
public class VideoDataFromDbDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public VideoDataFromDb getVideoDataByVideoId(int videoId) {
		String sql = "SELECT VIDEO_ID,FIELD_A,FIELD_B,FIELD_C FROM video_data_a WHERE VIDEO_ID=?";
		return (VideoDataFromDb) this.jdbcTemplate.queryForObject(sql, new Object[] { videoId }, new VideoDataFromDbMapper());
	}
}
