

package com.example.healthManagement.dto;

import com.example.healthManagement.Enum.bloodgroup;
import com.example.healthManagement.Enum.gender;
import com.example.healthManagement.Enum.patientstatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class patientResponse {

        private Long id;
        private String patientCode;
        private String firstName;
        private String lastName;
        private String age;
        private gender gender;
        private String phoneNumber;
        private String email;
        private bloodgroup bloodGroup;
        private String aadharNumber;
        private String address;
        private String emergencyContact;
        private String admitDate;
        private patientstatus status;
    }
