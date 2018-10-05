package lt.bit.laundry.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import lt.bit.laundry.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

	List<Client> findAllByOrderByIdAsc();

	List<Client> findAllByOrderByIdDesc();

}
