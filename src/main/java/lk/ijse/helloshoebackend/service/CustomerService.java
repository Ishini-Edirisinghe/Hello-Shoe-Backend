package lk.ijse.helloshoebackend.service;

import lk.ijse.helloshoebackend.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomer(String id);

    List<CustomerDTO> getAllCustomers();

    void deleteCustomer(String id);

    void updateCustomer(String id,CustomerDTO customerDTO);
}
