package blooossom.shortping.service;

import blooossom.shortping.entity.History;
import blooossom.shortping.entity.Product;
import blooossom.shortping.entity.User;
import blooossom.shortping.enums.HistoryType;

import java.util.List;
import java.util.Optional;

public interface HistoryService {
    boolean saveHistory(HistoryType type, User user, Product product, int amount);
    List<History> getHistory(String userId);
    Optional<History> getHistoryById(String id);
}
