package anue.project1.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import anue.project1.service.VideoDataService;

@RestController
public class VideoDataController {
	private Map<String, String> videoDataFromDb;
	private Map<String, String> videoDataFromAnotherDb;

	@Autowired
	VideoDataService videoDataService;

	@RequestMapping(value = "/api/getVideoData", method = RequestMethod.POST)
	public String getVideoData(@RequestParam(value = "videoId", required = true) int videoId,
			@RequestParam(value = "fields", required = true) String[] fields) {
		videoDataFromDb = null;
		videoDataFromAnotherDb = null;
		
		//check field to decide which database are accessed
		if (videoDataService.isFiledFromDb(fields)) {
			videoDataFromDb = videoDataService.getVideoDataFromDb(videoId);
		}
		if (videoDataService.isFiledFromAnotherDb(fields)) {
			videoDataFromAnotherDb = videoDataService.getVideoDataFromAnotherDb(videoId);
		}

		// merge data
		Map<String, String> videoData = new HashMap<>();
		if (null != videoDataFromDb) {
			videoData.putAll(videoDataFromDb);
		}
		if (null != videoDataFromAnotherDb) {
			videoData.putAll(videoDataFromAnotherDb);
		}

		// parse to json
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(videoData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
