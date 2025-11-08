package com.toby.hello_spring_boot.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdaeRequest {
    String password;
    String firstName;
    String lastName;
    LocalDate dbo;
}
