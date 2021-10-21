package Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sara Bermudez
 */
@Service
public class AudienceService {

    @Autowired
    private AudienceRepository metodosCrud;

    public List<Audience> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Audience> getAudience(int id) {
        return metodosCrud.getAudience(id);
    }

    public Audience save(Audience audience) {
        if (audience.getId() == null) {
            return metodosCrud.save(audience);
        } else {
            Optional<Audience> evt = metodosCrud.getAudience(audience.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(audience);
            } else {
                return audience;
            }
        }
    }

    public Audience update(Audience audience) {
        if (audience.getId() != null) {
            Optional<Audience> evt = metodosCrud.getAudience(audience.getId());
            if (!evt.isEmpty()) {
                if (audience.getName() != null) {
                    evt.get().setName(audience.getName());
                }
                if (audience.getOwner() != null) {
                    evt.get().setOwner(audience.getOwner());
                }
                if (audience.getCapacity() != null) {
                    evt.get().setCapacity(audience.getCapacity());
                }
                if (audience.getDescription() != null) {
                    evt.get().setDescription(audience.getDescription());
                }
                if (audience.getCategory() != null) {
                    evt.get().setCategory(audience.getCategory());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            } else {
                return audience;
            }
        } else {
            return audience;
        }
    }

    public boolean deleteAudience(int id) {
        Boolean aBoolean = getAudience(id).map(audience -> {
            metodosCrud.delete(audience);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
