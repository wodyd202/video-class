package com.ljy.videoclass.classroom.command.application;

import com.ljy.videoclass.classroom.domain.read.ElrolmentModel;

import java.util.Optional;

public interface ElrolmentRepository {
    Optional<ElrolmentModel> findByClassroomCodeAndRequester(String classroomCode, String requester);
}
