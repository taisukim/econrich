package com.example.econrich.dto.response.department;

import com.example.econrich.domain.Department;
import lombok.Data;

@Data
public class DepartmentLocationInfoRes {
    private Long departmentId;
    private String departmentName;
    private Long locationId;
    private String city;
    private String postalCode;
    private String stateProvince;
    private String streetAddress;
    private String countryId;
    private String countryName;
    private Long regionId;
    private String regionName;

    public DepartmentLocationInfoRes(Department department) {
        this.departmentId = department.getId();
        this.departmentName = department.getName();
        this.locationId = department.getLocation().getId();
        this.city = department.getLocation().getCity();
        this.postalCode = department.getLocation().getPostalCode();
        this.stateProvince = department.getLocation().getStateProvince();
        this.streetAddress = department.getLocation().getStreetAddress();
        this.countryId = department.getLocation().getCountry().getId();
        this.countryName = department.getLocation().getCountry().getName();
        this.regionId = department.getLocation().getCountry().getRegion().getId();
        this.regionName = department.getLocation().getCountry().getRegion().getName();
    }
}
