import pytest

from prog import Comparator

""" Тесты проверки программы"""


@pytest.fixture
def mylist1():
    a = [1, 2, 3]
    return a


@pytest.fixture
def mylist2():
    b = [12, 22, 0, 28, 52, 12]
    return b


@pytest.fixture
def mylist3():
    c = [1, '5', 3, 4, 5, 1]
    return c


"""Проверка корректности создания класса"""


def test_init(mylist1, mylist2):
    nums_list = Comparator(mylist1, mylist2)
    assert nums_list.arr_1 == mylist1
    assert nums_list.arr_2 == mylist2

    """Проверка корректности аргументов"""


def test_invalid_list_arguments(mylist1, mylist3):
    with pytest.raises(TypeError):
        nums_list = Comparator(mylist1, mylist3)
        nums_list.compare_averages()

    """Проверка корректности сообщения  о том, что значение среднего первого списка больше второго"""


def test_first_average_more(mylist1, mylist2, capfd):
    nums_list = Comparator(mylist2, mylist1)
    nums_list.compare_averages()
    captured = capfd.readouterr()
    assert captured.out.strip() == '"Первый список имеет большее среднее значение"'

    """Проверка корректности сообщения  о том, что среднее значение второго списка больше первого"""


def test_second_average_more(mylist1, mylist2, capfd):
    nums_list = Comparator(mylist1, mylist2)
    nums_list.compare_averages()
    captured = capfd.readouterr()
    assert captured.out.strip() == '"Второй список имеет большее среднее значение"'

    """Проверка корректности сообщения  о том, что средние значения списков равны"""


def test_equal_averages(mylist1, capfd):
    nums_list = Comparator(mylist1, mylist1)
    nums_list.compare_averages()
    captured = capfd.readouterr()
    assert captured.out.strip() == '"Средние значения равны"'
