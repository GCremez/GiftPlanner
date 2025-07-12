package repository;
import  model.Occasion;
import java.util.List;


public interface OccasionRepository {
    // TODO: Add DAO methods
    List<Occasion> findAll(); // Retrieve all occasions
    Occasion findById (int id); // Retrieve an occasion by its ID
    void save(Occasion occassion); // Save a new occasion
    void update(Occasion occasion); // Update an existing occasion
    void delete(int id); // Delete an occasion by its ID

} 