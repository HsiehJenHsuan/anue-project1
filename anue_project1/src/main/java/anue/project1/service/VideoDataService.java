package anue.project1.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anue.project1.dao.VideoDataFromAnotherDbDao;
import anue.project1.dao.VideoDataFromDbDao;
import anue.project1.model.VideoDataFromAnotherDb;
import anue.project1.model.VideoDataFromDb;

@Service
public class VideoDataService {
	private final String[] fieldsInDb = { "A", "B", "C" };
	private final String[] fieldsInAnotherDb = { "D", "E" };

	@Autowired
	VideoDataFromDbDao videoDataFromDbDao;
	@Autowired
	VideoDataFromAnotherDbDao videoDataFromAnotherDbDao;

	// check fields to see if data stored in database
	public boolean isFiledFromDb(String[] fields) {
		for (String field : fields) {
			if (Arrays.asList(fieldsInDb).contains(field)) {
				return true;
			}
		}
		return false;
	}

	// check fields to see if data stored in another database
	public boolean isFiledFromAnotherDb(String[] fields) {
		for (String field : fields) {
			if (Arrays.asList(fieldsInAnotherDb).contains(field)) {
				return true;
			}
		}
		return false;
	}

	// get data from first database
	public Map<String, String> getVideoDataFromDb(int videoId) {
		VideoDataFromDb videoDataFromDb = videoDataFromDbDao.getVideoDataByVideoId(videoId);
		Map<String, String> result = new HashMap<>();
		if (null != videoDataFromDb.getFiledA()) {
			result.put("filedA", videoDataFromDb.getFiledA());
		}
		if (null != videoDataFromDb.getFiledB()) {
			result.put("filedB", videoDataFromDb.getFiledB());
		}
		if (null != videoDataFromDb.getFiledC()) {
			result.put("filedC", videoDataFromDb.getFiledC());
		}
		return result;
	}

	// get data from second database
	public Map<String, String> getVideoDataFromAnotherDb(int videoId) {
		VideoDataFromAnotherDb videoDataFromAnotherDb = videoDataFromAnotherDbDao.getVideoDataByVideoId(videoId);
		Map<String, String> result = new HashMap<>();
		if (null != videoDataFromAnotherDb.getFiledD()) {
			result.put("filedD", videoDataFromAnotherDb.getFiledD());
		}
		if (null != videoDataFromAnotherDb.getFiledE()) {
			result.put("filedE", videoDataFromAnotherDb.getFiledE());
		}
		return result;
	}
}
