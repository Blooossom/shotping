package blooossom.shortping.repository;

import blooossom.shortping.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, String> {

    List<History> findByUserId(String userId);
}
