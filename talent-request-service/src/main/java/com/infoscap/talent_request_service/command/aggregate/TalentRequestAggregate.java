package com.infoscap.talent_request_service.command.aggregate;

import com.infoscap.talent_request_service.command.command.CreateTalentRequestCommand;
import com.infoscap.talent_request_service.core.events.TalentRequestCreateEvent;
import com.infoscap.tams_core_api.domain.CandidateSkills;
import com.infoscap.tams_core_api.domain.JobDescription;
import com.infoscap.tams_core_api.domain.RequestStatus;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Aggregate
public class TalentRequestAggregate {

    @AggregateIdentifier
    private String talentRequestId;
    private String talentRequestTitle;
    private JobDescription jobDescription;
    private CandidateSkills candidateSkills;
    private RequestStatus requestStatus;
    private LocalDate startDate;

    public TalentRequestAggregate(){};

    @CommandHandler
    public TalentRequestAggregate(CreateTalentRequestCommand createTalentRequestCommand){

        TalentRequestCreateEvent talentRequestCreateEvent = new TalentRequestCreateEvent();
        BeanUtils.copyProperties(createTalentRequestCommand, talentRequestCreateEvent);
        AggregateLifecycle.apply(talentRequestCreateEvent);
    };

    @EventSourcingHandler
    public void on (TalentRequestCreateEvent talentRequestCreateEvent){
        this.talentRequestId = talentRequestCreateEvent.getTalentRequestId();
        this.talentRequestTitle= talentRequestCreateEvent.getTalentRequestTitle();
        this.requestStatus= talentRequestCreateEvent.getRequestStatus();
        this.candidateSkills= talentRequestCreateEvent.getCandidateSkills();
        this.startDate= talentRequestCreateEvent.getStartDate();
        this.jobDescription = talentRequestCreateEvent.getJobDescription();
    }

}
