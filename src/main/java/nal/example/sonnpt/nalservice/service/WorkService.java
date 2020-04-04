package nal.example.sonnpt.nalservice.service;

import java.util.List;

import nal.example.sonnpt.nalservice.dto.WorkDto;
import nal.example.sonnpt.nalservice.entity.Work;

/**
* @author  Son
* @version 1.0
* @since   2020-03-04
*/
public interface WorkService {

	public Work addWork(WorkDto workDto);

	public void deleteWork(Long workId);

	public void editWork(Long id, WorkDto workDto);

	public boolean isExistById(Long workId);

	public List<Work> getlListWork(Integer pageNo, Integer pageSize, String sortBy);

}
