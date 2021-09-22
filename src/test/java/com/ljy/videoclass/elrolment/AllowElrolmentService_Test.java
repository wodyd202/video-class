package com.ljy.videoclass.elrolment;

import com.ljy.videoclass.classroom.command.application.AllowElrolmentService;
import com.ljy.videoclass.classroom.command.application.ElrolmentService;
import com.ljy.videoclass.classroom.command.application.OpenClassroomService;
import com.ljy.videoclass.classroom.domain.OpenClassroom;
import com.ljy.videoclass.classroom.domain.read.ClassroomModel;
import com.ljy.videoclass.classroom.domain.value.ClassroomCode;
import com.ljy.videoclass.classroom.domain.value.Register;
import com.ljy.videoclass.classroom.domain.value.Requester;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.ljy.videoclass.classroom.ClassroomFixture.aOpenClassroom;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class AllowElrolmentService_Test {
    @Autowired
    OpenClassroomService openClassroomService;

    @Autowired
    ElrolmentService elrolmentService;

    @Autowired
    AllowElrolmentService allowElrolmentService;

    @Test
    @DisplayName("수강신청 수락")
    void allow(){
        OpenClassroom openClassroom = aOpenClassroom().build();
        ClassroomModel classroomModel = openClassroomService.open(openClassroom, Register.of("00000000"));
        elrolmentService.elrolment(ClassroomCode.of(classroomModel.getCode()), Requester.of("elrolment"));

        assertDoesNotThrow(()->{
            allowElrolmentService.allowElrolment(ClassroomCode.of(classroomModel.getCode()), Requester.of("elrolment"), Register.of("00000000"));
        });
    }
}
