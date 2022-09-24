package com.iacsd.services;

import java.util.List;

import com.iacsd.dto.ScheduleModel;
import com.iacsd.dto.ScheduleRow;
import com.iacsd.pojos.Schedule;

public interface ScheduleService {

	Schedule extractSchedule(ScheduleModel scheduleM);
	Schedule save(Schedule schedule);
	List<Schedule> findByStd(String std);
	List<ScheduleRow> getScheduleRow(List<Schedule> list);
	List<Schedule> findByTeacherId(int teacherid);
	void deleteBySessionId(int id);
}
