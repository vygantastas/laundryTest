package lt.bit.laundry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lt.bit.laundry.entity.Client;
import lt.bit.laundry.repository.ClientRepository;

public class ClientServiceImpl implements ClientService {

	private ClientRepository clientRepository;

	@Autowired
	public void setClientsRepository(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public Client getClientById(Integer id) {
		
		return clientRepository.getOne(id);
	}

	@Override
	public void saveClient(Client client) {
		clientRepository.save(client);

	}

	@Override
	public void updateClient(Integer id, Client client) {
		Client clientTemp = clientRepository.getOne(id);
		clientTemp.setName(client.getName());
		clientTemp.setPhone(client.getPhone());
		clientRepository.save(clientTemp);
	}

	@Override
	public void deleteClient(Integer id) {
		clientRepository.deleteById(id);
	}

	@Override
	public List<Client> findAllByOrderByIdAsc() {
		return clientRepository.findAllByOrderByIdAsc();
	}

	@Override
	public List<Client> findAllByOrderByIdDesc() {
		return clientRepository.findAllByOrderByIdDesc();
	}

}
