package com.example.econrich.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Country {

    @Id
    @Column(name = "country_id", updatable = false, length = 2)
    private String id;

    @Column(name = "country_name", length = 40)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = CascadeType.ALL)
    private List<Location> location = new ArrayList<>();

}
