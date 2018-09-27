package anue.project1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import anue.project1.model.VideoDataFromAnotherDb;
import anue.project1.model.VideoDataFromAnotherDbMapper;

@Repository
public class VideoDataFromAnotherDbDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public VideoDataFromAnotherDb getVideoDataByVideoId(int videoId) {
		String sql = "SELECT VIDEO_ID,FIELD_D,FIELD_E FROM video_data_b WHERE VIDEO_ID=?";
		return (VideoDataFromAnotherDb) this.jdbcTemplate.queryForObject(sql, new Object[] { videoId }, new VideoDataFromAnotherDbMapper());
	}
}
