package com.moviebook.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registrations")
public class RegistrationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day_of_registration")
    @CreationTimestamp
    private LocalDateTime registrationDay;

    @Column(name = "info_ip")
    private String ipInfo;

    @Column(name = "is_referred")
    private boolean isReferred;

    public RegistrationInformation() {}

    public RegistrationInformation(String ipInfo, boolean isReferred ) {
        this.ipInfo = ipInfo;
        this.isReferred = isReferred;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getRegistrationDay() {
        return registrationDay;
    }

    public void setRegistrationDay(LocalDateTime registrationDay) {
        this.registrationDay = registrationDay;
    }

    public String getIpInfo() {
        return ipInfo;
    }

    public void setIpInfo(String ipInfo) {
        this.ipInfo = ipInfo;
    }

    public boolean isReferred() {
        return isReferred;
    }

    public void setReferred(boolean referred) {
        isReferred = referred;
    }

    @Override
    public String toString() {
        return "RegistrationInformation{" +
                "id=" + id +
                ", registrationDay=" + registrationDay +
                ", ipInfo='" + ipInfo + '\'' +
                ", isReferred=" + isReferred +
                '}';
    }
}
