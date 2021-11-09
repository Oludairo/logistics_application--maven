package african.semicolon.cheatah.services;

import african.semicolon.cheatah.data.models.Package;
import african.semicolon.cheatah.dtos.requests.AddPackageRequest;
import african.semicolon.cheatah.dtos.responses.AddPackageResponse;

public interface PackageService {
    AddPackageResponse addPackage(AddPackageRequest addPackageRequest);

    Package findMyPackageWithMy(Integer id);
}
