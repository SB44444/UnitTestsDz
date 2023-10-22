class Person:
        def __init__(self, balance=0):
            self.balance = balance

        def transfer_money(self, amount, bank):
            if amount <= 0 or amount > self.balance:
                raise ValueError("Invalid transfer amount")
            self.balance -= amount
            bank.receive_money(amount)
