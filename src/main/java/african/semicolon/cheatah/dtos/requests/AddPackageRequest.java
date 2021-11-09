package african.semicolon.cheatah.dtos.requests;

import lombok.Data;

@Data
public class AddPackageRequest {
    private String senderEmail;
//    private String senderName;
//    private String senderPhone;
    private String receiverName;
    private String deliveryAddress;
    private double packageWeight;
    private String packageDescription;
    private String receiverPhone;
}
