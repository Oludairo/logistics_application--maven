package african.semicolon.cheatah.services;

import african.semicolon.cheatah.data.models.Package;
import african.semicolon.cheatah.data.models.Sender;
import african.semicolon.cheatah.data.repositories.PackageRepository;
import african.semicolon.cheatah.data.repositories.PackageRepositoryImpl;
import african.semicolon.cheatah.dtos.requests.AddPackageRequest;
import african.semicolon.cheatah.dtos.responses.AddPackageResponse;
import african.semicolon.cheatah.exceptions.SenderDoesNotExistException;
import african.semicolon.cheatah.utils.ModelMapper;

import java.util.Optional;

public class PackageServiceImpl implements  PackageService{
    private static final PackageRepository packageRepository = new PackageRepositoryImpl();
    private final SenderService senderService = new SenderServiceImpl();

    @Override
    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest) {
        Optional<Sender> senderOptional = senderService.findSenderByEmail(addPackageRequest.getSenderEmail());
        if (senderOptional == null) throw new SenderDoesNotExistException("Sender not registered");
        Package aPackage = ModelMapper.map(addPackageRequest);
        Package savedPackage = packageRepository.save(aPackage);

        return ModelMapper.map(savedPackage);

        //convert addpackage request to a package
//       Package aPackage = ModelMapper.map(addPackageRequest);


        //save package
//        Package savedPackage = packageRepository.save(aPackage);

        //convert saved package to addpackage response
//        AddPackageResponse response = ModelMapper.map(savedPackage);

        //return converted response
//        return response;
    }

    @Override
    public Package findMyPackageWithMy(Integer id) {
        return packageRepository.findPackageById(id);
    }

    public Package findPackageWithMy(Integer id){
        return packageRepository.findById(id);
    }
}
