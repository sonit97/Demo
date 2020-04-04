package nal.example.sonnpt.nalservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import nal.example.sonnpt.nalservice.dto.WorkDto;
import nal.example.sonnpt.nalservice.entity.Work;
import nal.example.sonnpt.nalservice.repository.WorkListRepository;
import nal.example.sonnpt.nalservice.repository.WorkRepository;
import nal.example.sonnpt.nalservice.service.WorkService;
import nal.example.sonnpt.nalservice.util.Common;

/**
* @author  Son
* @version 1.0
* @since   2020-03-04
*/
@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
	private WorkRepository workRepository;

	@Autowired
	private WorkListRepository workListRepository;

	/**
	 * Process add work
	 * 
	 * @param workId the Work ID
	 *
	 */
	@Override
	public Work addWork(WorkDto workDto) {
		Work work = new Work();

		work = workRepository.save(Common.convertDtoToObj(workDto, work));
		return work;
	}

	/**
	 * Process delete work
	 * 
	 * @param workId the Work ID
	 *
	 */
	@Override
	public void deleteWork(Long workId) {
		workRepository.deleteById(workId);
	}

	/**
	 * Process edit work
	 * 
	 * @param workId  the Work ID
	 * @param workDto the Work
	 *
	 */
	@Override
	public void editWork(Long workId, WorkDto workDto) {
		Work work = getWorkById(workId);

		workRepository.save(Common.convertDtoToObj(workDto, work));

	}

	/**
	 * Process check workId exist
	 * 
	 * @param workId the Work ID
	 *
	 */
	@Override
	public boolean isExistById(Long workId) {
		return workRepository.existsById(workId) ? false : true;

	}

	/**
	 * Process get list work with workId
	 * 
	 * @param workId the Work ID
	 *
	 */
	private Work getWorkById(Long workId) {
		Optional<Work> optional = workRepository.findById(workId);
		return optional.get();
	}

	/**
	 * Process get List work page and sort
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param sortBy
	 *
	 */
	@Override
	public List<Work> getlListWork(Integer pageNo, Integer pageSize, String sortBy) {

		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

		Page<Work> pagedResult = workListRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Work>();
		}

	}

}
