package com.maveric.techhub.nomination.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class NominationDTO {

    private String id;
    private String nomineeId;
    private String typeId;
    private String type;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
