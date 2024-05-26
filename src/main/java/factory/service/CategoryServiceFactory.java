package factory.service;

import model.enums.ServiceType;
import service.CategoryService;
import service.CategoryServiceImpl;

public class CategoryServiceFactory implements BaseServiceFactory {
    @Override
    public CategoryService getBaseService(ServiceType serviceType) {
        if (serviceType.equals(ServiceType.CATEGORY)){
            return new CategoryServiceImpl();
        }
        return null;
    }
}
