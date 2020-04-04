package nal.example.sonnpt.nalservice.repository;

import org.springframework.stereotype.Repository;
import nal.example.sonnpt.nalservice.entity.Work;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
* @author  Son
* @version 1.0
* @since   2020-03-04
*/
@Repository
public interface WorkListRepository extends PagingAndSortingRepository<Work, Long> {

}
