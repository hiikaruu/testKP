package models;

import lombok.*;

import java.util.ArrayList;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetResponse {
    private long id;
    private Category category;
    private String name;
    private ArrayList<String> photoUrls;
    private Tag[] tags;
    private String status;

}
