package nal.example.sonnpt.nalservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nal.example.sonnpt.nalservice.dto.WorkDto;
import nal.example.sonnpt.nalservice.entity.Work;
import nal.example.sonnpt.nalservice.service.WorkService;

/**
 * @author Son
 * @version 1.0
 * @since 2020-03-04
 */
@RestController
@RequestMapping("/work")
public class WorkController {

	@Autowired
	private WorkService workService;

	@RequestMapping(value = "/create-work", method = RequestMethod.POST)
	public ResponseEntity<Work> createWork(@RequestBody WorkDto writeDto) {
		if (writeDto == null)
			return new ResponseEntity<Work>(HttpStatus.BAD_REQUEST);
		try {
			Work work = workService.addWork(writeDto);
			return new ResponseEntity<Work>(work, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<Work>(HttpStatus.BAD_REQUEST);

		}

	}

	@RequestMapping(value = "/delete-work/{workId}", method = RequestMethod.DELETE)
	public final ResponseEntity<?> removeWork(@PathVariable(value = "workId") Long workId) {

		try {
			long id = Long.valueOf(workId);
			if (workService.isExistById(id)) {
				return new ResponseEntity<String>("WorkId not exist", HttpStatus.NOT_FOUND);
			}
			workService.deleteWork(workId);
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>("WorkId invalid", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/edit-work/{workId}", method = RequestMethod.PUT)
	public final ResponseEntity<?> editWork(@PathVariable(value = "workId") Long workId,
			@RequestBody WorkDto writeDto) {
		try {
			long id = Long.valueOf(workId);
			if (workService.isExistById(id)) {
				return new ResponseEntity<String>("WorkId not exist", HttpStatus.NOT_FOUND);
			}
			workService.editWork(id, writeDto);
			return ResponseEntity.status(HttpStatus.OK).body("Success");

		} catch (Exception ex) {
			return new ResponseEntity<String>("WorkId invalid", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/list-work", method = RequestMethod.GET)
	public ResponseEntity<List<Work>> getAllEmployees(@RequestParam(defaultValue = "1") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "workId") String sortBy) {
		List<Work> list = workService.getlListWork(pageNo, pageSize, sortBy);

		return new ResponseEntity<List<Work>>(list, HttpStatus.OK);
	}

}
