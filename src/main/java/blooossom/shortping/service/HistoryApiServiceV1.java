package blooossom.shortping.service;

import blooossom.shortping.entity.History;
import blooossom.shortping.entity.Product;
import blooossom.shortping.entity.User;
import blooossom.shortping.enums.HistoryType;
import blooossom.shortping.repository.HistoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
public class HistoryApiServiceV1 implements HistoryService{

    private static final Logger log = LoggerFactory.getLogger(HistoryApiServiceV1.class);
    private final HistoryRepository historyRepository;

    @Transactional
    @Override
    public boolean saveHistory(HistoryType type, User user, Product product, int amount) {
        try {
            History history = History.builder()
                    .type(type)
                    .user(user)
                    .product(product)
                    .createdDate(LocalDateTime.now())
                    .build();
            historyRepository.save(history);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    @Override
    public List<History> getHistory(String userId) {
        try {
            return historyRepository.findByUserId(userId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<History> getHistoryById(String id) {
        try {
            return historyRepository.findById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Optional.empty();
        }
    }

    // 무작위 해시값 생성 메서드
    private String generateRandomHash() {
        try {
            String uuid = UUID.randomUUID().toString();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(uuid.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // 고유 해시값 생성 메서드
    private String generateUniqueHash() {
        String hash;
        do {
            hash = generateRandomHash();
        } while (historyRepository.existsById(hash));
        return hash;
    }
}
