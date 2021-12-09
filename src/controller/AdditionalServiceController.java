package controller;

import model.AdditionalService;
import service.AdditionalServiceImpl;

import java.util.List;

public class AdditionalServiceController {
    AdditionalServiceImpl additionalService = new AdditionalServiceImpl();

    public List<AdditionalService> findAll() {
        return additionalService.findAll();
    }

    public void createNewAdditionalService(String name, int price) {
        additionalService.createNewAdditionalService(name, price);
    }

    public int getIndexById(int id) {
        return additionalService.getIndexById(id);
    }

    public void changeAdditionalServiceInfo(int index, String name, int price) {
        additionalService.changeAdditionalServiceInfo(index, name, price);
    }

    public void removeAdditionalService(int index) {
        additionalService.removeAdditionalService(index);
    }

}
