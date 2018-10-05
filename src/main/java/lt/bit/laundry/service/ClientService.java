package lt.bit.laundry.service;

import java.util.List;

import lt.bit.laundry.entity.Client;

public interface ClientService {
    Client getClientById(Integer id);
    void saveClient(Client client);
    void updateClient(Integer id, Client client);
    void deleteClient(Integer id);
    List<Client> findAllByOrderByIdAsc();
    List<Client> findAllByOrderByIdDesc();
}
