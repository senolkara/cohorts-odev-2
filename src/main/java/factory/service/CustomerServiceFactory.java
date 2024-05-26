package factory.service;

import model.enums.ServiceType;
import service.CustomerService;
import service.CustomerServiceImpl;

public class CustomerServiceFactory implements BaseServiceFactory {
    @Override
    public CustomerService getBaseService(ServiceType serviceType) {
        if (serviceType.equals(ServiceType.CUSTOMER)){
            return new CustomerServiceImpl();
        }
        return null;
    }
}
