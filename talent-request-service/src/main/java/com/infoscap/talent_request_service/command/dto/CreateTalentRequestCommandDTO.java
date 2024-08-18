package com.infoscap.talent_request_service.command.dto;

import com.infoscap.tams_core_api.domain.CandidateSkills;
import com.infoscap.tams_core_api.domain.JobDescription;
import com.infoscap.tams_core_api.domain.RequestStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CreateTalentRequestCommandDTO {

    private String talentRequestTitle;
    private JobDescription jobDescription;
    private CandidateSkills candidateSkills;
    private RequestStatus requestStatus;
    private LocalDate startDate;
}
