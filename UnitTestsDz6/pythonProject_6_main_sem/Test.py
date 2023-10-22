from unittest import TestCase, main
from unittest.mock import Mock
from Person import Person
from Bank import Bank


class Test(TestCase):
    def setUp(self):
        self.person = Person(1000)

    def test_transfer_with_mock(self):
        bank_mock = Mock()  # Создаём мок-объект для банка
        self.person.transfer_money(500, bank_mock)
        bank_mock.receive_money.assert_called_with(500)  # Проверяем, был ли вызван метод receive_money с аргументом 500

    def test_receive_money(self):
        bank = Bank()
        bank.receive_money(500)
        self.assertEquals(bank.balance, 500)
        # self.assertTrue((bank.balance == 501))

    def test_all(self):
        bank_mock = Mock()
        self.person.transfer_money(300, bank_mock)
        self.assertEquals(self.person.balance, 700)


if __name__ == "__main__":
    main()