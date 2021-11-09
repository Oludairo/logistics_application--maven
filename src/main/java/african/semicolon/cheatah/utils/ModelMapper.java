package african.semicolon.cheatah.utils;

import african.semicolon.cheatah.data.models.Package;
import african.semicolon.cheatah.data.models.Sender;
import african.semicolon.cheatah.data.models.TrackingData;
import african.semicolon.cheatah.dtos.requests.AddPackageRequest;
import african.semicolon.cheatah.dtos.requests.AddTrackingInfoRequest;
import african.semicolon.cheatah.dtos.requests.RegisterSenderRequest;
import african.semicolon.cheatah.dtos.responses.AddPackageResponse;
import african.semicolon.cheatah.dtos.responses.AddTrackingInfoResponse;
import african.semicolon.cheatah.dtos.responses.RegisterSenderResponse;

public class ModelMapper {

    public static Package map(AddPackageRequest addPackageRequest){
        Package aPackage = new Package();
        aPackage.setName(addPackageRequest.getPackageDescription());
        aPackage.setSenderEmail(addPackageRequest.getSenderEmail());
//        aPackage.setSenderPhone(addPackageRequest.getSenderPhone());
        aPackage.setDeliveryAddress(addPackageRequest.getDeliveryAddress());
//        aPackage.setSenderName(addPackageRequest.getSenderName());
        aPackage.setReceiverPhone(addPackageRequest.getReceiverPhone());
        aPackage.setReceiverName(addPackageRequest.getReceiverName());
        aPackage.setNetWeight(addPackageRequest.getPackageWeight());
        return aPackage;
    }

    public static AddPackageResponse map(Package savedPackage){
        AddPackageResponse response = new AddPackageResponse();

        response.setPackageName(savedPackage.getName());
        response.setPackageWeight(savedPackage.getNetWeight());
        response.setReceiverName(savedPackage.getReceiverName());
        response.setReceiverPhone(savedPackage.getReceiverPhone());
        response.setTrackingNumber(savedPackage.getId());
        return response;
    }
    public static Sender map(RegisterSenderRequest registerSenderRequest) {
        Sender sender = new Sender();
        sender.setSenderName(registerSenderRequest.getSenderName());
        sender.setPhoneNumber(registerSenderRequest.getPhoneNumber());
        sender.setEmailAddress(registerSenderRequest.getSenderEmail());
        return sender;
    }

    public static RegisterSenderResponse map(Sender sender) {
        RegisterSenderResponse response = new RegisterSenderResponse();
        response.setSenderEmail(sender.getEmailAddress());
        return response;
    }

    public static AddTrackingInfoResponse map(TrackingData trackingData, AddTrackingInfoRequest addTrackingInfoRequest) {
        AddTrackingInfoResponse addTrackingInfoResponse = new AddTrackingInfoResponse();
        addTrackingInfoResponse.setDateTime(trackingData.getDateTimeOfEvent());
        addTrackingInfoResponse.setEvent(trackingData.getEvent());
        addTrackingInfoResponse.setPackageId(addTrackingInfoRequest.getPackageId());
        return addTrackingInfoResponse;
    }
}
