package models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserNFResponse {
    private int code;
    private String type;
    private String message;
}
