package blooossom.shortping.service;

import blooossom.shortping.entity.Product;
import blooossom.shortping.entity.User;
import blooossom.shortping.enums.HistoryType;
import blooossom.shortping.exception.PayErrorCode;
import blooossom.shortping.exception.PayException;
import blooossom.shortping.exception.UserErrorCode;
import blooossom.shortping.exception.UserException;
import blooossom.shortping.repository.ProductRepository;
import blooossom.shortping.repository.UserRepository;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class PayApiServiceV1 implements PayService{

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final HistoryService historyService;

    @Transactional
    @Override
    public void pay(String userId, String productId, int amount) {
        try {
            User user = userRepository.findByUserId(userId)
                    .orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND_EXCEPTION));

            Product product = productRepository.findById(productId).orElseThrow(NoResultException::new);

            if (product.getAmount() < amount) {
                throw new PayException(PayErrorCode.NOT_ENOUGH_AMOUNT_EXCEPTION);
            } else if (product.getPrice() * amount > user.getCash()) {
                throw new PayException(PayErrorCode.NOT_ENOUGH_CASH_EXCEPTION);
            } else {
                user.setCash(user.getCash() - (amount * product.getPrice()));
                userRepository.save(user);

                User seller = userRepository.findByUserId(product.getSellerId())
                        .orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND_EXCEPTION, "사용자를 찾을 수 없습니다."));

                historyService.saveHistory(HistoryType.BUY, user, product, amount);
                historyService.saveHistory(HistoryType.SELL, seller, product, amount);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
