package com.example.econrich.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class JobHistoryId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long employeeId;
    private LocalDate startDate;
}
