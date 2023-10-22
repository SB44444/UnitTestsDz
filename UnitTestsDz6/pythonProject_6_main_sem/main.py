# This is a sample Python script.
from Tasks import Tasks
from Person import Person
from Bank import Bank


if __name__ == '__main__':
    # Примеры использования функций:
    # 1
    avg = Tasks.find_average([1, 2, 3, 4, 5])
    print(avg)

    # 3
    person = Tasks.Person()
    bank = Tasks.Bank()
    person.transfer_money(100, bank)
    print(bank.balance)

    # 5
    result = Tasks.divide(10, 2)
    print(result)

    # 6
    product = Tasks.multiply(4, 5)
    print(product)

    # 8
    sq = Tasks.square(4)
    print(sq)

    # 9
    prime = Tasks.is_prime(7)
    print(prime)