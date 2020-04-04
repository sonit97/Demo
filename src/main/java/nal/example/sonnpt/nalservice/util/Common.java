package nal.example.sonnpt.nalservice.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import nal.example.sonnpt.nalservice.dto.WorkDto;
import nal.example.sonnpt.nalservice.entity.Work;

import java.text.ParseException;

/**
* @author  Son
* @version 1.0
* @since   2020-03-04
*/
public class Common {
	private static final String DATE_PATTERN = "yyyy-MM-dd";

	public static final Date getDate(String date) throws ParseException {
		if (date == null || "".equals(date)) {
			return null;
		}

		return new SimpleDateFormat(DATE_PATTERN).parse(date);
	}
	
	public static Work convertDtoToObj(WorkDto workDto, Work work) {
		try {
			work.setWorkName(workDto.getWorkName());
			work.setStartingDate(Common.getDate(workDto.getStartingDate()));
			work.setEndingDate(Common.getDate(workDto.getEndingDate()));
			work.setStatus(workDto.getStatus());
		} catch (ParseException e) {
			//logger.error("ERROR", e);
		}

		return work;
	}

}
