package lk.ijse.helloshoebackend.service;

import lk.ijse.helloshoebackend.dto.ItemDTO;


public interface InventoryService {
    void saveItem(ItemDTO itemDTO);

    ItemDTO getItem(String id);

    void deleteItem(String id);

    void updateItem(String id, String itemDesc, String pic);
}
