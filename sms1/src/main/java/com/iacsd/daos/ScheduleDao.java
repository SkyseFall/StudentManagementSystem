package com.iacsd.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.pojos.Schedule;

import java.lang.String;
import java.util.List;

public interface ScheduleDao extends JpaRepository<Schedule, Integer> {
	Schedule save(Schedule schedule);
	List<Schedule> findByStd(String std);
	List<Schedule> findByTeacherId(int teacherid);
	void deleteBySessionId(int id);
}
