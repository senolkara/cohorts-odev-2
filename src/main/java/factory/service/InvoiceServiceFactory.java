package factory.service;

import model.enums.ServiceType;
import service.InvoiceService;
import service.InvoiceServiceImpl;

public class InvoiceServiceFactory implements BaseServiceFactory {
    @Override
    public InvoiceService getBaseService(ServiceType serviceType) {
        if (serviceType.equals(ServiceType.INVOICE)){
            return new InvoiceServiceImpl();
        }
        return null;
    }
}
