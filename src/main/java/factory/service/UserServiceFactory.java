package factory.service;

import model.enums.ServiceType;
import service.UserService;
import service.UserServiceImpl;

public class UserServiceFactory implements BaseServiceFactory {
    @Override
    public UserService getBaseService(ServiceType serviceType) {
        if (serviceType.equals(ServiceType.USER)){
            return new UserServiceImpl();
        }
        return null;
    }
}
