package blooossom.shortping.service;

import blooossom.shortping.dto.UserDto;
import blooossom.shortping.entity.User;
import blooossom.shortping.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserApiServiceV1 implements UserService{

    private final UserRepository userRepository;

    @Transactional
    @Override
    public void register(UserDto.SignUpRequest signUpRequest) {
        try {
            userRepository.saveAndFlush(UserDto.SignUpRequest.toEntity(signUpRequest, generateUniqueHash()));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public User login(String userId, String password) {
        return null;
    }

    @Override
    public void logout(String userId) {

    }

    @Override
    public User findUserById(String userId) {
        return null;
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
        } while (userRepository.existsById(hash));
        return hash;
    }
}

