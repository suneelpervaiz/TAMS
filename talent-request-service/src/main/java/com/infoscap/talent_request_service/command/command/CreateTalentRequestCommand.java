package com.infoscap.talent_request_service.command.command;

import com.infoscap.tams_core_api.domain.CandidateSkills;
import com.infoscap.tams_core_api.domain.JobDescription;
import com.infoscap.tams_core_api.domain.RequestStatus;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.AggregateIdentifier;

import java.time.LocalDate;

@Data
@Builder
public class CreateTalentRequestCommand {

    @AggregateIdentifier
    private String talentRequestId;
    private String talentRequestTitle;
    private JobDescription jobDescription;
    private CandidateSkills candidateSkills;
    private RequestStatus requestStatus;
    private LocalDate startDate;
}
