package com.maveric.techhub.nomination.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Nomination")
@EntityListeners(AuditingEntityListener.class)
public class Nomination {
    @Id
    @Column
    private String id;
    @Column
    private String nomineeId;
    @Column
    private String typeId;
    @Column
    private String type;
    @Column
    @CreatedDate
    private LocalDateTime createdDate;
    @Column
    @LastModifiedDate
    private LocalDateTime updatedDate;
}
