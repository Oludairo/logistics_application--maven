package african.semicolon.cheatah.data.repositories;

import african.semicolon.cheatah.data.models.Package;

import java.util.List;

public interface PackageRepository {
    Package save(Package aPackage);

    List<Package> findAll();

    void delete(Package aPackage);

    void deleteById(Integer id);

    Package findPackageById(Integer id);

    Package findById(Integer id);
}
