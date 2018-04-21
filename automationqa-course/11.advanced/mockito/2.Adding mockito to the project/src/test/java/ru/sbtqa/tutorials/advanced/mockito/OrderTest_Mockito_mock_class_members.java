package ru.sbtqa.tutorials.advanced.mockito;

import org.junit.jupiter.api.Test;

import ru.sbtqa.tutorials.advanced.mockito.services.PromotionService;

import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Tests for {@code Order} implementation.
 */
class OrderTest_Mockito_mock_class_members {
    /**
     * {@code BankAccount} mock.
     */
    private final BankAccount account = mock(BankAccount.class);

    /**
     * {@code PromotionService} mock.
     */
    private final PromotionService promotionService = mock(PromotionService.class);

    /**
     * {@code Order} real instance.
     */
    private final Order order = new Order(promotionService);

    @Test
    void testSucceedIfEnoughFunds() throws InsufficientFundsException {
        Item cake = new Item("Cake", valueOf(70));
        order.buyItem(cake, account);
        verify(account).withdraw(cake.getPrice());
        verify(promotionService).getGiftsByItem(cake);
        assertTrue(order.getItems().contains(cake));
    }
}
