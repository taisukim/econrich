package com.example.econrich.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "regions")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Region {

    @Id
    @GeneratedValue
    @Column(name = "region_id", updatable = false, columnDefinition = "INT(11) UNSIGNED")
    private Long id;

    @Column(name = "region_name", length = 25)
    private String name;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Country> country = new ArrayList<>();

}
