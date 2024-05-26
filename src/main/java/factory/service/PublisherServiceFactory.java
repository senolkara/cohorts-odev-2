package factory.service;

import model.enums.ServiceType;
import service.*;

public class PublisherServiceFactory implements BaseServiceFactory {
    @Override
    public PublisherService getBaseService(ServiceType serviceType) {
        if (serviceType.equals(ServiceType.PUBLISHER)){
            return new PublisherServiceImpl();
        }
        return null;
    }
}
