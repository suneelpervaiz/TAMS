package com.infoscap.talent_request_service.command.service;

import com.infoscap.talent_request_service.command.command.CreateTalentRequestCommand;
import com.infoscap.talent_request_service.command.dto.CreateTalentRequestCommandDTO;
import com.infoscap.talent_request_service.command.dto.TalentRequestResponseDTO;
import com.infoscap.tams_core_api.domain.RequestStatus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TalentRequestService   {

    private final CommandGateway commandGateway;

    public TalentRequestService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public ResponseEntity createNewTalentRequest(CreateTalentRequestCommandDTO createTalentRequestCommandDTO){
        CreateTalentRequestCommand createTalentRequestCommand = CreateTalentRequestCommand.builder()
                .talentRequestId(UUID.randomUUID().toString())
                .requestStatus(RequestStatus.OPEN)
                .talentRequestTitle(createTalentRequestCommandDTO.getTalentRequestTitle())
                .candidateSkills(createTalentRequestCommandDTO.getCandidateSkills())
                .jobDescription(createTalentRequestCommandDTO.getJobDescription())
                .startDate(createTalentRequestCommandDTO.getStartDate())
                .build();

        try {
            commandGateway.sendAndWait(createTalentRequestCommand);
            TalentRequestResponseDTO talentRequestResponseDTO = new TalentRequestResponseDTO();
            BeanUtils.copyProperties(createTalentRequestCommand, talentRequestResponseDTO);

            return new ResponseEntity<>(talentRequestResponseDTO, HttpStatus.CREATED);

        }catch(Exception exception) {
            var exceptionMessage = "Unable to create new Talent Message";
            return new ResponseEntity(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
