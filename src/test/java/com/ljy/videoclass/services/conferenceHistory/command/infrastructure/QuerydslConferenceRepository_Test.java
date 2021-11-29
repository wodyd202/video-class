package com.ljy.videoclass.services.conferenceHistory.command.infrastructure;

import com.ljy.videoclass.services.conferenceHistory.domain.Conference;
import com.ljy.videoclass.services.conferenceHistory.domain.ConferenceRepository;
import com.ljy.videoclass.services.conferenceHistory.domain.OpenConferenceValidator;
import com.ljy.videoclass.services.conferenceHistory.domain.value.ConferenceCode;
import com.ljy.videoclass.services.conferenceHistory.domain.value.ConferenceTitle;
import com.ljy.videoclass.services.conferenceHistory.domain.value.Creator;
import com.ljy.videoclass.services.conferenceHistory.domain.value.LimitCount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QuerydslConferenceRepository_Test {
    @Autowired
    ConferenceRepository conferenceRepository;

    @Autowired
    OpenConferenceValidator openConferenceValidator;

    @Test
    void 데이터베이스에_회의정보_저장(){
        // given
        Conference conference = Conference.builder()
                .code(ConferenceCode.of("code"))
                .title(ConferenceTitle.of("회의실 제목"))
                .limitCount(LimitCount.of(2))
                .build();

        conference.open(Creator.of("생성자"), openConferenceValidator);

        // when
        conferenceRepository.save(conference);
    }
}