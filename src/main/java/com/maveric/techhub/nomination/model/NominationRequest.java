package com.maveric.techhub.nomination.model;

import com.maveric.techhub.nomination.util.ServiceConstants;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class NominationRequest {

    @NotBlank(message = ServiceConstants.NOMINEE_ID_IS_MANDATORY)
    private String nomineeId;
    @NotBlank(message = ServiceConstants.TYPE_ID_IS_MANDATORY)
    private String typeId;
    @NotBlank(message = ServiceConstants.TYPE_IS_MANDATORY)
    private String type;
    @Column
    @CreatedDate
    private LocalDateTime createdDate;
    @Column
    @LastModifiedDate
    private LocalDateTime updatedDate;

}
