package african.semicolon.cheatah.controllers;

import african.semicolon.cheatah.data.models.Package;
import african.semicolon.cheatah.dtos.requests.AddPackageRequest;
import african.semicolon.cheatah.dtos.responses.AddPackageResponse;
import african.semicolon.cheatah.exceptions.SenderDoesNotExistException;
import african.semicolon.cheatah.services.PackageService;
import african.semicolon.cheatah.services.PackageServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PackageController {

    private final PackageService packageService = new PackageServiceImpl();

    @PostMapping("/api/addpackage")
    public ResponseEntity<?> addPackage(@RequestBody AddPackageRequest addPackageRequest){
        try {
            AddPackageResponse response = packageService.addPackage(addPackageRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (SenderDoesNotExistException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/api/package/{id}")
    public Package findPackageById(@PathVariable("id") Integer id){
        return packageService.findMyPackageWithMy(id);
    }
}
