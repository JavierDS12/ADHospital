package domain.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private int id;
    private String name;
    private String spetialization;
    private String phone;
}
