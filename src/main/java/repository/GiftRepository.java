package repository;

import model.Gift;
import java.util.List;

public interface GiftRepository {
    void save(Gift gift);
    Gift findById(int id);
    List<Gift> findAll();
    void update(Gift gift);
    void delete(int id);
}