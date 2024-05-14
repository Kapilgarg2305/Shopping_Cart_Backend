package com.example.Shopping_Cart_Backend.dto.RequestDto;

import com.example.Shopping_Cart_Backend.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequestDto {

    String name;

    String emailId;

    String mobNo;

    Gender gender;

}
