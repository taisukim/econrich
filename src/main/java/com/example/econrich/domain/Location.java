package com.example.econrich.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false, columnDefinition = "INT(11) UNSIGNED")
    /**
     * @Column(columnDefinition = "INT(11)"
     * @COlumn(length = 11)
     * 이 둘의 차이는 위에꺼는 숫자형지정이고 아래꺼는 문자수 지정이다
     */
    private Long id;

    @Column(length = 40)
    private String streetAddress;
    @Column(length = 12)
    private String postalCode;
    @Column(length = 40, nullable = false)
    private String city;
    @Column(length = 25)
    private String stateProvince;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

}
