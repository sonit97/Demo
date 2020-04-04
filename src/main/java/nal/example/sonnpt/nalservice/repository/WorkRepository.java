package nal.example.sonnpt.nalservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nal.example.sonnpt.nalservice.entity.Work;

/**
* @author  Son
* @version 1.0
* @since   2020-03-04
*/
@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {
	
}
