package factory.service;

import model.enums.ServiceType;
import service.AuthorService;
import service.AuthorServiceImpl;

public class AuthorServiceFactory implements BaseServiceFactory{
    @Override
    public AuthorService getBaseService(ServiceType serviceType) {
        if (serviceType.equals(ServiceType.AUTHOR)){
            return new AuthorServiceImpl();
        }
        return null;
    }
}
