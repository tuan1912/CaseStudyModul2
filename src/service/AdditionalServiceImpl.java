package service;

import io.ConfigReadAndWrite;
import io.Path;
import model.AdditionalService;

import java.util.List;

public class AdditionalServiceImpl {
    static ConfigReadAndWrite<AdditionalService> configReadAndWrite = new ConfigReadAndWrite<>();
    List<AdditionalService> additionalServices = configReadAndWrite.readFromFile(Path.PATH_ADDITIONAL_SERVICES);

    public AdditionalServiceImpl() {
        try {
            if (!additionalServices.isEmpty()) {
                int maxAdditionalServiceId = 0;
                for (int i = 0; i < additionalServices.size(); i++) {
                    if (additionalServices.get(i).getServiceId() > maxAdditionalServiceId) maxAdditionalServiceId = additionalServices.get(i).getServiceId();
                }
                AdditionalService.id = maxAdditionalServiceId;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile() {
        configReadAndWrite.writeToFile(Path.PATH_ADDITIONAL_SERVICES, additionalServices);
    }
    public List<AdditionalService> findAll(){
        return additionalServices;
    }
    public void createNewAdditionalService(String name, int price){
        additionalServices.add(new AdditionalService(name,price));
        writeToFile();
    }

    public int getIndexById(int Id) {
        int NOT_EXIST_ID = -1;
        for (int i = 0; i < additionalServices.size(); i++) {
            boolean isId = Id == additionalServices.get(i).getServiceId();
            if (isId) return i;
        }
        return NOT_EXIST_ID;
    }
    public void changeAdditionalServiceInfo(int index,String name, int price){
        additionalServices.get(index).setName(name);
        additionalServices.get(index).setPrice(price);
        writeToFile();
    }
    public void removeAdditionalService(int index){
        additionalServices.remove(index);
        writeToFile();
    }








}
