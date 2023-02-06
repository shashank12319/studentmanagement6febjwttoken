package com.wittybrains.studentmanagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wittybrains.studentmanagement.model.Attendance;
import com.wittybrains.studentmanagement.repository.AttendanceRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public void saveAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
    }
}
