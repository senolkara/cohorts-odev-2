package factory.service;

import model.enums.ServiceType;
import service.OrderService;
import service.OrderServiceImpl;

public class OrderServiceFactory implements BaseServiceFactory {
    @Override
    public OrderService getBaseService(ServiceType serviceType) {
        if (serviceType.equals(ServiceType.ORDER)){
            return new OrderServiceImpl();
        }
        return null;
    }
}
