package com.wittybrains.studentmanagement.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wittybrains.studentmanagement.model.Attendance;

import org.springframework.security.access.annotation.Secured;

@RestController
public class AttendanceController {

    @Secured("ROLE_TEACHER")
    @PostMapping("/attendance")
    public void markAttendance(@RequestBody Attendance attendance) {
        // Implementation to store the attendance record in the database
    }
}
