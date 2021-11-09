package african.semicolon.cheatah.data.repositories;

import african.semicolon.cheatah.data.models.Package;

import static org.junit.jupiter.api.Assertions.*;

class PackageRepositoryImplTest {
    PackageRepository packageRepository;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        packageRepository = new PackageRepositoryImpl();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    public Package saveNewPackage(){
        Package aPackage = new Package();
        aPackage.setName("Sleeping Mat");
        aPackage.setSenderEmail("Jerry@email.com");
        aPackage.setReceiverName("Dharmy");
        aPackage.setReceiverPhone("0807930430");
        aPackage.setDeliveryAddress("312 Herbert Macaulay Way, Sabo Yaba Lagos");
        aPackage.setNetWeight(23.5);

        return saveNewPackage();
    }

    @org.junit.jupiter.api.Test
    void updatePackageTest() {
        Package aPackage = new Package();
        aPackage.setName("Sleeping Mat");
        aPackage.setSenderEmail("Jerry@email.com");
//        aPackage.setSenderName("Jerry");
        aPackage.setReceiverName("Dharmy");
        aPackage.setReceiverPhone("0807930430");
        aPackage.setDeliveryAddress("312 Herbert Macaulay Way, Sabo Yaba Lagos");
        aPackage.setNetWeight(23.5);
//        aPackage.setSenderPhone(aPackage.getReceiverPhone());

        Package savedPackage = packageRepository.save(aPackage);
        savedPackage.setName("Sniper");
        Package updatedPackage = packageRepository.save(savedPackage);
        assertEquals(1, updatedPackage.getId());

    }

    @org.junit.jupiter.api.Test
    void findAll() {
        Package aPackage = new Package();
        aPackage.setName("Sleeping Mat");
        aPackage.setSenderEmail("Jerry@email.com");
//        aPackage.setSenderName("Jerry");
        aPackage.setReceiverName("Dharmy");
        aPackage.setReceiverPhone("0807930430");
        aPackage.setDeliveryAddress("312 Herbert Macaulay Way, Sabo Yaba Lagos");
        aPackage.setNetWeight(23.5);
//        aPackage.setSenderPhone(aPackage.getReceiverPhone());

        Package updatePackage = packageRepository.save(aPackage);
        assertEquals(1, packageRepository.findAll().size());
    }

    @org.junit.jupiter.api.Test
    void delete() {
        Package aPackage = new Package();
        aPackage.setName("Sleeping Mat");
        aPackage.setSenderEmail("Jerry@email.com");
//        aPackage.setSenderName("Jerry");
        aPackage.setReceiverName("Dharmy");
        aPackage.setReceiverPhone("0807930430");
        aPackage.setDeliveryAddress("312 Herbert Macaulay Way, Sabo Yaba Lagos");
        aPackage.setNetWeight(23.5);
//        aPackage.setSenderPhone(aPackage.getReceiverPhone());

        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(1, packageRepository.findAll().size());

        packageRepository.delete(savedPackage);
        assertEquals(0, packageRepository.findAll().size());
    }

    @org.junit.jupiter.api.Test
    void deleteById() {
        Package aPackage = new Package();
        aPackage.setName("Sleeping Mat");
        aPackage.setSenderEmail("Jerry@email.com");
//        aPackage.setSenderName("Jerry");
        aPackage.setReceiverName("Dharmy");
        aPackage.setReceiverPhone("0807930430");
        aPackage.setDeliveryAddress("312 Herbert Macaulay Way, Sabo Yaba Lagos");
        aPackage.setNetWeight(23.5);
//        aPackage.setSenderPhone(aPackage.getReceiverPhone());

        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(1, packageRepository.findAll().size());

        packageRepository.deleteById(1);
        assertEquals(0, packageRepository.findAll().size());
    }

    @org.junit.jupiter.api.Test
    void findPackageTrackingNumber() {
        Package aPackage = new Package();
        aPackage.setName("Sleeping Mat");
        aPackage.setSenderEmail("Jerry@email.com");
//        aPackage.setSenderName("Jerry");
        aPackage.setReceiverName("Dharmy");
        aPackage.setReceiverPhone("0807930430");
        aPackage.setDeliveryAddress("312 Herbert Macaulay Way, Sabo Yaba Lagos");
        aPackage.setNetWeight(23.5);
//        aPackage.setSenderPhone(aPackage.getReceiverPhone());

        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(savedPackage, packageRepository.findPackageById(1));
    }
}