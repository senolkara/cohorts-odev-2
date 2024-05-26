package factory.service;

import model.enums.ServiceType;

public interface BaseServiceFactory {
    BaseService getBaseService(ServiceType serviceType);
}
