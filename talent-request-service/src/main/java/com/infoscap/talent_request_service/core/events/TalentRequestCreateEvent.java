package com.infoscap.talent_request_service.core.events;

import com.infoscap.tams_core_api.domain.CandidateSkills;
import com.infoscap.tams_core_api.domain.JobDescription;
import com.infoscap.tams_core_api.domain.RequestStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TalentRequestCreateEvent {

    private String talentRequestId;
    private String talentRequestTitle;
    private JobDescription jobDescription;
    private CandidateSkills candidateSkills;
    private RequestStatus requestStatus;
    private LocalDate startDate;
}
