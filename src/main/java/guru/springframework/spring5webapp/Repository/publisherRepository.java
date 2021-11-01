package guru.springframework.spring5webapp.Repository;

import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface publisherRepository extends CrudRepository<Publisher,Long>
{


}
